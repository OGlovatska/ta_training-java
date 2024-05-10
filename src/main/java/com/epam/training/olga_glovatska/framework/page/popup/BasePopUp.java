package com.epam.training.olga_glovatska.framework.page.popup;

import com.epam.training.olga_glovatska.framework.page.util.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class BasePopUp {
    protected final WebDriver webDriver;

    public BasePopUp(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    protected void switchToTab(String originalTab, int numberOfWindows) {
        WaitUtil.waitForOpenNewTab(webDriver, 10, numberOfWindows);
        Set<String> windowHandles = webDriver.getWindowHandles();
        windowHandles.stream()
                .filter(windowHandle -> !originalTab.contentEquals(windowHandle))
                .findFirst().ifPresent(windowHandle -> webDriver.switchTo().window(windowHandle));
    }
}
