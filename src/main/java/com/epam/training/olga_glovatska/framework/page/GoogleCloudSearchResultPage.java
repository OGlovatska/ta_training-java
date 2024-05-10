package com.epam.training.olga_glovatska.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.olga_glovatska.framework.util.WaitUtil.waitForElementVisibility;

public class GoogleCloudSearchResultPage extends BasePage {

    @FindBy(xpath = "//span[text()='calculator']/ancestor::div/preceding-sibling::div/a")
    private WebElement calculator;

    public GoogleCloudSearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected GoogleCloudSearchResultPage openPage() {
        throw new RuntimeException("The page opens in response to the search request " +
                "and should not be accessed directly.");
    }

    public GoogleCloudPricingCalculatorPage clickCalculator(){
        waitForElementVisibility(driver, calculator, 15);
        calculator.click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}
