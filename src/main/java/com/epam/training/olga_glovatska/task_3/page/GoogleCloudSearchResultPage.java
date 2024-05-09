package com.epam.training.olga_glovatska.task_3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.olga_glovatska.task_3.util.WaitUtil.waitForElementVisibility;

public class GoogleCloudSearchResultPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'calculator')]/ancestor::div[@class='x9K9hf wVBoU']//a[@class='K5hUy']")
    private WebElement calculator;

    public GoogleCloudSearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected GoogleCloudSearchResultPage openPage() {
        throw new RuntimeException("The page opens in response to the search request " +
                "and should not be accessed directly.");
    }

    public GoogleCloudPlatformPricingCalculator clickCalculator(){
        waitForElementVisibility(webDriver, calculator, 15);
        calculator.click();
        return new GoogleCloudPlatformPricingCalculator(webDriver);
    }
}
