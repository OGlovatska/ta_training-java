package com.epam.training.olga_glovatska.framework;

import com.epam.training.olga_glovatska.framework.page.GoogleCloudMainPage;
import com.epam.training.olga_glovatska.framework.page.GoogleCloudSearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.training.olga_glovatska.framework.service.GoogleCloudPricingCalculatorCreator.getSearchPageTitle;
import static com.epam.training.olga_glovatska.framework.service.GoogleCloudPricingCalculatorCreator.getSearchRequest;

public class SmokeTest extends BaseTest {

    @Test
    public void initiateCalculatorSearch() {
        GoogleCloudMainPage page = new GoogleCloudMainPage(driver);
        GoogleCloudSearchResultPage result = page.openPage()
                .clickMagnifyingGlassIcon()
                .inputSearchRequest(getSearchRequest())
                .initiateSearch();

        Assert.assertEquals(result.getPageTitle(), getSearchPageTitle());
    }
}
