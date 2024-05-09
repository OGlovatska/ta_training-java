package com.epam.training.olga_glovatska.task_3.page.popup;

import com.epam.training.olga_glovatska.task_3.page.CostEstimateSummaryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.olga_glovatska.task_3.util.WaitUtil.*;

public class ShareCostPopUp extends BasePopUp {

    @FindBy(xpath = "//a[@track-name='open estimate summary']")
    private WebElement openEstimateSummaryButton;

    @FindBy(xpath = "//div[span[text()='Total estimated cost']]/div/label")
    private WebElement totalEstimatedCost;

    public ShareCostPopUp(WebDriver webDriver) {
        super(webDriver);
    }

    public CostEstimateSummaryPage clickEstimateSummaryButton() {
        waitForElementVisibility(webDriver, openEstimateSummaryButton, 10);
        openEstimateSummaryButton.click();

        String originalTab = webDriver.getWindowHandle();
        switchToTab(originalTab, 2);

        return new CostEstimateSummaryPage(webDriver);
    }

    public String getTotalEstimatedCost() {
        waitForElementVisibility(webDriver, totalEstimatedCost, 10);
        return totalEstimatedCost.getText();
    }
}
