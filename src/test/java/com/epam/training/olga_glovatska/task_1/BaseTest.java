package com.epam.training.olga_glovatska.task_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected WebDriver webDriver;

    @BeforeEach
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
