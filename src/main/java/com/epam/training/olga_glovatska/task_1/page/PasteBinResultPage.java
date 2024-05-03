package com.epam.training.olga_glovatska.task_1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasteBinResultPage extends BasePage {

    public PasteBinResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected BasePage openPage() {
        throw new RuntimeException("The page opens in response to the creation of a new paste " +
                "and should not be accessed directly.");
    }

    public String getPasteText(){
        WebElement pasteText = getElementWithWaitVisibility(By.xpath("//*[@class='de1']"));
        return pasteText.getText();
    }

    public String getPasteTitle(){
        WebElement pasteTitle = getElementWithWaitVisibility(By.xpath("//*[@class='info-top']"));
        return pasteTitle.getText();
    }

    public String getExpiration(){
        WebElement expiration = getElementWithWaitVisibility(By.xpath("//*[@class='expire']"));
        return expiration.getText();
    }
}
