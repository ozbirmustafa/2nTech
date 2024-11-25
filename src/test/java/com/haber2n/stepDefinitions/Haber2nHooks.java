package com.haber2n.stepDefinitions;

import com.haber2n.pages.AllPagesHaber2n;
import com.common.utilities.ConfigurationReader;
import com.common.utilities.Driver;
import com.haber2n.utilities.Haber2nMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Haber2nHooks extends AllPagesHaber2n {
    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("baseUrlHaber"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Haber2nMethods.takeScreenshot(scenario.getName());
        }
        Driver.quitDriver();
    }
}

