package com.epam.training.olga_glovatska.framework.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class WaitUtil {

    public static void waitForElementVisibility(WebDriver webDriver, WebElement element, long seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForOpenNewTab(WebDriver webDriver, long seconds, int numberOfWindows) {
        new WebDriverWait(webDriver, Duration.ofSeconds(seconds)).until(numberOfWindowsToBe(numberOfWindows));
    }
}
