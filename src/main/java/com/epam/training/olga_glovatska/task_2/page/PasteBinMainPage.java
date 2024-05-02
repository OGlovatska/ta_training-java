package com.epam.training.olga_glovatska.task_2.page;

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

    @FindBy(xpath = "//*[@id='select2-postform-format-container']")
    private WebElement syntaxHighlightingDropDown;

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

    public PasteBinMainPage selectPasteSyntaxHighlighting(String syntaxHighlighting) {
        syntaxHighlightingDropDown.click();
        WebElement option = webDriver.findElement(By.xpath("//li[text()='" + syntaxHighlighting + "']"));
        option.click();
        return this;
    }

    public PasteBinMainPage selectPasteExpiration(String expiration) {
        expirationDropDown.click();
        WebElement option = webDriver.findElement(By.xpath("//li[text()='" + expiration + "']"));
        option.click();
        return this;
    }

    public PasteBinMainPage setPasteTitle(String title) {
        pasteTitle.sendKeys(title);
        return this;
    }

    public PasteBinResultPage createNewPaste(){
        createNewPasteButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new PasteBinResultPage(webDriver);
    }
}