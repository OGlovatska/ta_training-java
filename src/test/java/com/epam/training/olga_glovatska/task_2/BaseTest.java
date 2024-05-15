package com.epam.training.olga_glovatska.task_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
