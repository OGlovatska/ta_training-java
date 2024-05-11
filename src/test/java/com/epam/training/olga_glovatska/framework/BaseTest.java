package com.epam.training.olga_glovatska.framework;

import com.epam.training.olga_glovatska.framework.driver.DriverSingleton;
import com.epam.training.olga_glovatska.framework.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod
    public void tearDown(){
        DriverSingleton.closeDriver();
        driver = null;
    }
}
