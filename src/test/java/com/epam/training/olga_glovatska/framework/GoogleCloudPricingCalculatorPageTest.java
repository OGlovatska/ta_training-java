package com.epam.training.olga_glovatska.framework;

import com.epam.training.olga_glovatska.framework.model.GoogleCloudPricingCalculator;
import com.epam.training.olga_glovatska.framework.page.CostEstimateSummaryPage;
import com.epam.training.olga_glovatska.framework.page.GoogleCloudMainPage;
import com.epam.training.olga_glovatska.framework.page.GoogleCloudPricingCalculatorPage;
import com.epam.training.olga_glovatska.framework.page.GoogleCloudSearchResultPage;
import com.epam.training.olga_glovatska.framework.page.popup.ShareCostPopUp;
import org.testng.annotations.Test;

import static com.epam.training.olga_glovatska.framework.assertions.GoogleCloudPricingCalculatorAssertions.*;
import static com.epam.training.olga_glovatska.framework.service.GoogleCloudPricingCalculatorCreator.*;
import static org.testng.Assert.assertEquals;

public class GoogleCloudPricingCalculatorPageTest extends BaseTest {

    @Test
    public void searchTest() {
        GoogleCloudMainPage page = new GoogleCloudMainPage(driver);

        GoogleCloudSearchResultPage resultPage = initiateCalculatorSearch(page);

        GoogleCloudPricingCalculator pricingCalculator = createGoogleCloudPricingCalculatorModel();
        GoogleCloudPricingCalculatorPage calculator = createGoogleCloudPricingCalculatorPage(resultPage, pricingCalculator);

        String costFromCalculator = calculator.getEstimateCost();
        calculator.clickAddToEstimateOnCostDetailsButton().clickCloseButton();
        pricingCalculator.setEstimateCost(costFromCalculator);

        ShareCostPopUp shareCostPopUp = calculator.clickShareButton();
        String costFromSharePopUp = shareCostPopUp.getTotalEstimatedCost();

        assertEquals(costFromCalculator + " / month", costFromSharePopUp);

        CostEstimateSummaryPage summaryPage = shareCostPopUp.clickEstimateSummaryButton();

        assertCalculatorModelWithSummaryResponse(pricingCalculator, summaryPage);

    }

    private GoogleCloudSearchResultPage initiateCalculatorSearch(GoogleCloudMainPage page) {
        return page.openPage()
                .clickMagnifyingGlassIcon()
                .inputSearchRequest(getSearchRequest())
                .initiateSearch();
    }
}
