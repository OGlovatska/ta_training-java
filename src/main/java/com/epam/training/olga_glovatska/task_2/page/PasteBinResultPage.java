package com.epam.training.olga_glovatska.task_2.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.epam.training.olga_glovatska.task_2.util.WaitUtil.*;

public class PasteBinResultPage extends BasePage {

    @FindBy(xpath = "//*[@class='de1']")
    private List<WebElement> pasteText;

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
        waitForElementsVisibility(webDriver, pasteText, 15);
        StringBuilder pasteText = new StringBuilder();
        for (WebElement element : this.pasteText){
            pasteText.append(element.getText()).append("\n");
        }
        return pasteText.toString().trim();
    }

    public String syntaxHighlighting(){
        waitForElementVisibility(webDriver, syntaxHighlighting, 15);
        return syntaxHighlighting.getText();
    }
}
