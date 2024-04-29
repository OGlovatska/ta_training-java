package com.epam.training.olga_glovatska.task_1.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        return pasteText.getText();
    }

    public String getPasteTitle(){
        return pasteTitle.getText();
    }

    public String getExpiration(){
        return expiration.getText();
    }
}
