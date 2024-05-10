package com.epam.training.olga_glovatska.framework;

import com.epam.training.olga_glovatska.framework.driver.DriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = DriverSingleton.getDriver();
    }

    @AfterEach
    public void tearDown(){
        DriverSingleton.closeDriver();
        driver = null;
    }
}
