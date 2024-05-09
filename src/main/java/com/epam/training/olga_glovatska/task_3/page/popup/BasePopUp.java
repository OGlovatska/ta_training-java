package com.epam.training.olga_glovatska.task_3.page.popup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

import static com.epam.training.olga_glovatska.task_3.util.WaitUtil.waitForOpenNewTab;

public class BasePopUp {
    protected final WebDriver webDriver;

    public BasePopUp(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    protected void switchToTab(String originalTab, int numberOfWindows) {
        waitForOpenNewTab(webDriver, 10, numberOfWindows);
        Set<String> windowHandles = webDriver.getWindowHandles();
        windowHandles.stream()
                .filter(windowHandle -> !originalTab.contentEquals(windowHandle))
                .findFirst().ifPresent(windowHandle -> webDriver.switchTo().window(windowHandle));
    }
}
