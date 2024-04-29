package com.epam.training.olga_glovatska.task_1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasteBinMainPage extends BasePage {
    private static final String MAIN_PAGE_URL = "https://pastebin.com/";

    @FindBy(xpath = "//*[@id='postform-text']")
    private WebElement pasteText;

    @FindBy(xpath = "//*[@id='postform-name']")
    private WebElement pasteTitle;

    @FindBy(xpath = "//*[@id='select2-postform-expiration-container']")
    private WebElement expirationDropDown;

    @FindBy(xpath = "//*[@class='btn -big']")
    private WebElement createNewPasteButton;

    public PasteBinMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public PasteBinMainPage openPage() {
        webDriver.get(MAIN_PAGE_URL);
        return this;
    }

    public PasteBinMainPage setPasteText(String text) {
        pasteText.sendKeys(text);
        return this;
    }

    public PasteBinMainPage setPasteTitle(String title) {
        pasteTitle.sendKeys(title);
        return this;
    }

    public PasteBinMainPage selectPasteExpiration(String expiration) {
        expirationDropDown.click();
        WebElement option = webDriver.findElement(By.xpath("//li[text()='" + expiration + "']"));
        option.click();
        return this;
    }

    public PasteBinResultPage createNewPaste(){
        createNewPasteButton.click();
        return new PasteBinResultPage(webDriver);
    }
}
