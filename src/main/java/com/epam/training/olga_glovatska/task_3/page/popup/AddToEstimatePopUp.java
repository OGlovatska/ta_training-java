package com.epam.training.olga_glovatska.task_3.page.popup;

import com.epam.training.olga_glovatska.task_3.page.BasePage;
import com.epam.training.olga_glovatska.task_3.page.GoogleCloudPlatformPricingCalculator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.olga_glovatska.task_3.util.WaitUtil.waitForElementVisibility;

public class AddToEstimatePopUp extends BasePage {

    @FindBy(xpath = "//div[@class='d5NbRd-EScbFb-JIbuQc PtwYlf']")
    private WebElement computerEngineButton;

    @FindBy(xpath = "//button[@class='pYTkkf-Bz112c-LgbsSe bwApif-zMU9ub']")
    private WebElement closeButton;

    public AddToEstimatePopUp(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected AddToEstimatePopUp openPage() {
        throw new RuntimeException("This pop-up opens after clicking on the \"Add to estimate\" button and" +
                "can not be accessed directly ");
    }

    public GoogleCloudPlatformPricingCalculator clickComputerEngineButton() {
        waitForElementVisibility(webDriver, computerEngineButton, 10);
        computerEngineButton.click();
        return new GoogleCloudPlatformPricingCalculator(webDriver);
    }

    public GoogleCloudPlatformPricingCalculator clickCloseButton(){
        waitForElementVisibility(webDriver, closeButton, 10);
        closeButton.click();
        return new GoogleCloudPlatformPricingCalculator(webDriver);
    }
}
