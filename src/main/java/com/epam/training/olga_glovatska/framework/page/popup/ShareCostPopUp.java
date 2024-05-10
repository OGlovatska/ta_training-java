package com.epam.training.olga_glovatska.framework.page.popup;

import com.epam.training.olga_glovatska.framework.page.CostEstimateSummaryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.olga_glovatska.framework.util.WaitUtil.waitForElementVisibility;

public class ShareCostPopUp extends BasePopUp {

    @FindBy(xpath = "//a[@track-name='open estimate summary']")
    private WebElement openEstimateSummaryButton;

    @FindBy(xpath = "//div[span[text()='Total estimated cost']]/div/label")
    private WebElement totalEstimatedCost;

    public ShareCostPopUp(WebDriver webDriver) {
        super(webDriver);
    }

    public CostEstimateSummaryPage clickEstimateSummaryButton() {
        waitForElementVisibility(driver, openEstimateSummaryButton, 10);
        openEstimateSummaryButton.click();

        String originalTab = driver.getWindowHandle();
        switchToTab(originalTab, 2);

        return new CostEstimateSummaryPage(driver);
    }

    public String getTotalEstimatedCost() {
        waitForElementVisibility(driver, totalEstimatedCost, 10);
        return totalEstimatedCost.getText();
    }
}
