package com.tech2n.stepDefinitions;

import com.common.utilities.ConfigurationReader;
import com.common.utilities.Driver;
import com.haber2n.utilities.Haber2nMethods;
import com.haber2n.pages.AllPagesHaber2n;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Tech2nHooks extends AllPagesHaber2n {
    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("baseUrlTech"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Haber2nMethods.takeScreenshot(scenario.getName());
        }
        Driver.quitDriver();
    }
}

