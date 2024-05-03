package com.epam.training.olga_glovatska.task_1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriver webDriver;

    private final WebDriverWait webDriverWait;

    private final int DEFAULT_TIMEOUT = 20;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        PageFactory.initElements(this.webDriver, this);
    }

    protected abstract BasePage openPage();

    protected WebElement getElementWithWaitVisibility(By by) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
