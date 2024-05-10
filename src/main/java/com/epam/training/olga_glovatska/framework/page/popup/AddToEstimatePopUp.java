package com.epam.training.olga_glovatska.framework.page.popup;

import com.epam.training.olga_glovatska.framework.page.GoogleCloudPricingCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.olga_glovatska.framework.page.util.WaitUtil.waitForElementVisibility;

public class AddToEstimatePopUp extends BasePopUp {

    @FindBy(xpath = "//h2[text()='Compute Engine']")
    private WebElement computerEngineButton;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeButton;

    public AddToEstimatePopUp(WebDriver webDriver) {
        super(webDriver);
    }

    public GoogleCloudPricingCalculatorPage clickComputerEngineButton() {
        waitForElementVisibility(webDriver, computerEngineButton, 10);
        computerEngineButton.click();
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }

    public GoogleCloudPricingCalculatorPage clickCloseButton(){
        waitForElementVisibility(webDriver, closeButton, 10);
        closeButton.click();
        return new GoogleCloudPricingCalculatorPage(webDriver);
    }
}
