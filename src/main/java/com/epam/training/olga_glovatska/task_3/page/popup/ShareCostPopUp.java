package com.epam.training.olga_glovatska.task_3.page.popup;

import com.epam.training.olga_glovatska.task_3.page.BasePage;
import com.epam.training.olga_glovatska.task_3.page.CostEstimateSummaryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

import static com.epam.training.olga_glovatska.task_3.util.WaitUtil.*;

public class ShareCostPopUp extends BasePage {

    @FindBy(xpath = "//a[@class='tltOzc MExMre rP2xkc jl2ntd']")
    private WebElement openEstimateSummaryButton;

    @FindBy(xpath = "//div[@class='fbc2ib']/label[@class='gN5n4 MyvX5d D0aEmf']")
    private WebElement totalEstimatedCost;

    public ShareCostPopUp(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected ShareCostPopUp openPage() {
        throw new RuntimeException("This pop-up opens after clicking on the \"Share\" button and" +
                "can not be accessed directly ");
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
