package com.epam.training.olga_glovatska.task_2.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtil {

    public static void waitForElementVisibility(WebDriver webDriver, WebElement element, long seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementsVisibility(WebDriver webDriver, List<WebElement> element, long seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
}
