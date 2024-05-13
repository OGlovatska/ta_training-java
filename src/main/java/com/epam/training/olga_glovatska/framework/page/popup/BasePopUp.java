package com.epam.training.olga_glovatska.framework.page.popup;

import com.epam.training.olga_glovatska.framework.util.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public abstract class BasePopUp {
    protected final WebDriver driver;

    public BasePopUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    protected void switchToTab(String originalTab, int numberOfWindows) {
        WaitUtil.waitForOpenNewTab(driver, 10, numberOfWindows);
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.stream()
                .filter(windowHandle -> !originalTab.contentEquals(windowHandle))
                .findFirst().ifPresent(windowHandle -> driver.switchTo().window(windowHandle));
    }
}
