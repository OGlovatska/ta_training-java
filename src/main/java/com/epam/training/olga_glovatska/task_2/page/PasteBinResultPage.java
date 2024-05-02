package com.epam.training.olga_glovatska.task_2.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PasteBinResultPage extends BasePage {

    @FindBy(xpath = "//*[@class='de1']")
    private List<WebElement> pasteText;

    @FindBy(xpath = "//*[@class='info-top']")
    private WebElement pasteTitle;

    @FindBy(xpath = "//*[@class='expire']")
    private WebElement expiration;

    @FindBy(xpath = "//div[@class='left']/a[@class='btn -small h_800']")
    private WebElement syntaxHighlighting;

    public PasteBinResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected BasePage openPage() {
        throw new RuntimeException("The page opens in response to the creation of a new paste " +
                "and should not be accessed directly.");
    }

    public String getPasteText(){
        StringBuilder pasteText = new StringBuilder();
        for (WebElement element : this.pasteText){
            pasteText.append(element.getText()).append("\n");
        }
        return pasteText.toString().trim();
    }

    public String getPasteTitle(){
        return pasteTitle.getText();
    }

    public String syntaxHighlighting(){
        return syntaxHighlighting.getText();
    }
}
