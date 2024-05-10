package com.epam.training.olga_glovatska.framework;

import com.epam.training.olga_glovatska.framework.page.CostEstimateSummaryPage;
import com.epam.training.olga_glovatska.framework.page.GoogleCloudMainPage;
import com.epam.training.olga_glovatska.framework.page.GoogleCloudPricingCalculatorPage;
import com.epam.training.olga_glovatska.framework.page.GoogleCloudSearchResultPage;
import com.epam.training.olga_glovatska.framework.page.popup.ShareCostPopUp;
import org.junit.jupiter.api.Test;

import static com.epam.training.olga_glovatska.task_3.util.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleCloudPricingCalculatorPageTest extends BaseTest {

    @Test
    public void searchTest() {
        GoogleCloudMainPage page = new GoogleCloudMainPage(webDriver);

        GoogleCloudSearchResultPage resultPage = initiateCalculatorSearch(page);

        GoogleCloudPricingCalculatorPage calculator = fillOutFormAndCalculate(resultPage);

        String costFromCalculator = calculator.getEstimateCost();
        calculator.clickAddToEstimateOnCostDetailsButton().clickCloseButton();

        ShareCostPopUp shareCostPopUp = calculator.clickShareButton();
        String costFromSharePopUp = shareCostPopUp.getTotalEstimatedCost();

        assertEquals(costFromCalculator + " / month", costFromSharePopUp);

        CostEstimateSummaryPage summaryPage = shareCostPopUp.clickEstimateSummaryButton();

        assertSummaryPage(costFromCalculator, summaryPage);

    }

    private void assertSummaryPage(String costFromCalculator, CostEstimateSummaryPage summaryPage) {
        assertEquals(costFromCalculator, summaryPage.getTotalEstimatedCost());
        assertEquals(NUMBER_OF_INSTANCES, summaryPage.getNumberOfInstances());
        assertEquals(OPERATION_SYSTEM, summaryPage.getOperationSystem());
        assertEquals(PROVISION_MODEL, summaryPage.getProvisioningModel());
        assertEquals(EXPECTED_MACHINE_TYPE, summaryPage.getMachineType());
        assertEquals(MODEL_GPU, summaryPage.getModelGPU());
        assertEquals(NUMBER_OF_GPU, summaryPage.getNumberOfGPUs());
        assertEquals(LOCAL_SSD, summaryPage.getLocalSSD());
        assertEquals(REGION, summaryPage.getRegion());
        assertEquals(COMMITTED_USE_DISCOUNT_OPTIONS, summaryPage.getCommittedUse());
    }

    private GoogleCloudPricingCalculatorPage fillOutFormAndCalculate(GoogleCloudSearchResultPage resultPage) {
        return resultPage
                .clickCalculator()
                .clickAddToEstimateButton()
                .clickComputerEngineButton()
                .insertNumberOfInstances(NUMBER_OF_INSTANCES)
                .selectOperationSystem(OPERATION_SYSTEM)
                .selectRegularProvisionModel()
                .selectMachineFamily(MACHINE_FAMILY)
                .selectSeries(SERIES)
                .selectMachineType(MACHINE_TYPE)
                .switchAddGPUs()
                .selectModelGPU(MODEL_GPU)
                .selectNumberOfGPUs(NUMBER_OF_GPU)
                .selectLocalSSD(LOCAL_SSD)
                .selectRegion(REGION)
                .selectOneYearCommittedUse();
    }

    private GoogleCloudSearchResultPage initiateCalculatorSearch(GoogleCloudMainPage page) {
        return page.openPage()
                .clickMagnifyingGlassIcon()
                .inputSearchRequest(SEARCH_REQUEST)
                .initiateSearch();
    }
}
