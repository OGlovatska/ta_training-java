package com.epam.training.olga_glovatska.task_3;

import com.epam.training.olga_glovatska.task_3.page.CostEstimateSummaryPage;
import com.epam.training.olga_glovatska.task_3.page.GoogleCloudMainPage;
import com.epam.training.olga_glovatska.task_3.page.GoogleCloudPlatformPricingCalculatorPage;
import com.epam.training.olga_glovatska.task_3.page.GoogleCloudSearchResultPage;
import com.epam.training.olga_glovatska.task_3.page.popup.ShareCostPopUp;
import org.testng.annotations.Test;

import static com.epam.training.olga_glovatska.task_3.util.TestData.*;
import static org.testng.Assert.assertEquals;

public class GoogleCloudPlatformPricingCalculatorPageTest extends BaseTest {

    @Test
    public void searchTest() {
        GoogleCloudMainPage page = new GoogleCloudMainPage(webDriver);

        GoogleCloudSearchResultPage resultPage = initiateCalculatorSearch(page);

        GoogleCloudPlatformPricingCalculatorPage calculator = fillOutFormAndCalculate(resultPage);

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

    private GoogleCloudPlatformPricingCalculatorPage fillOutFormAndCalculate(GoogleCloudSearchResultPage resultPage) {
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
