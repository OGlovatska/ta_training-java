package com.epam.training.olga_glovatska.task_3.page.popup;

import com.epam.training.olga_glovatska.task_3.page.GoogleCloudPlatformPricingCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.olga_glovatska.task_3.util.WaitUtil.waitForElementVisibility;

public class AddToEstimatePopUp extends BasePopUp {

    @FindBy(xpath = "//h2[text()='Compute Engine']")
    private WebElement computerEngineButton;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeButton;

    public AddToEstimatePopUp(WebDriver webDriver) {
        super(webDriver);
    }

    public GoogleCloudPlatformPricingCalculatorPage clickComputerEngineButton() {
        waitForElementVisibility(webDriver, computerEngineButton, 10);
        computerEngineButton.click();
        return new GoogleCloudPlatformPricingCalculatorPage(webDriver);
    }

    public GoogleCloudPlatformPricingCalculatorPage clickCloseButton(){
        waitForElementVisibility(webDriver, closeButton, 10);
        closeButton.click();
        return new GoogleCloudPlatformPricingCalculatorPage(webDriver);
    }
}
