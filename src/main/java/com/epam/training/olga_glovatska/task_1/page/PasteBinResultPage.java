package com.epam.training.olga_glovatska.task_1.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.olga_glovatska.task_1.util.WaitUtil.waitForElementVisibility;

public class PasteBinResultPage extends BasePage {

    @FindBy(xpath = "//*[@class='de1']")
    private WebElement pasteText;

    @FindBy(xpath = "//*[@class='info-top']")
    private WebElement pasteTitle;

    @FindBy(xpath = "//*[@class='expire']")
    private WebElement expiration;

    public PasteBinResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected BasePage openPage() {
        throw new RuntimeException("The page opens in response to the creation of a new paste " +
                "and should not be accessed directly.");
    }

    public String getPasteText(){
        waitForElementVisibility(webDriver, pasteText, 15);
        return pasteText.getText();
    }

    public String getPasteTitle(){
        waitForElementVisibility(webDriver, pasteTitle, 15);
        return pasteTitle.getText();
    }

    public String getExpiration(){
        waitForElementVisibility(webDriver, expiration, 15);
        return expiration.getText();
    }
}
