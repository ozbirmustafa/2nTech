package com.common.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class Driver {

    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(Driver.class); // Logger tanımlaması

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser");
            logger.info("Initializing the driver for browser: {}", browser);  // Log mesajı eklendi
            switch (browser) {
                case "chrome":
                    logger.info("Launching Chrome browser.");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    logger.info("Launching Firefox browser.");
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    logger.info("Launching Edge browser.");
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    logger.info("Launching Safari browser.");
                    driver = new SafariDriver();
                    break;
                default:
                    logger.error("Unsupported browser: {}", browser);
                    throw new IllegalArgumentException();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            logger.info("Driver initialized successfully.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            logger.info("Quitting the driver.");
            driver.quit();
            driver = null; // Ensure the driver is properly cleaned up
            logger.info("Driver quit and cleaned up successfully.");
        } else {
            logger.warn("Driver is not initialized. Quit operation skipped.");
        }
    }
}

