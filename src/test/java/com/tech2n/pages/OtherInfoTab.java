package com.tech2n.pages;

import com.tech2n.utilities.Tech2nMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.common.constants.Constants.URL_OF_SUCCESS_JOB_APPLICATION;
import static com.tech2n.stepDefinitions.Tech2nHooks.driver;

public class OtherInfoTab extends AllPagesTech2n {

    private static final Logger logger = LogManager.getLogger(OtherInfoTab.class);

    @FindBy(xpath = "//button[text()='Detaylar']//parent::div//span")
    private List<WebElement> listJobTitles;

    @FindBy(xpath = "//div[text()='Gönder']")
    private WebElement btnSubmit;

    @FindBy(xpath = "//*[text()='Form Başarı ile gönderildi. Katıldığınız için teşekkür ederiz.']")
    private WebElement txtSuccessMsjApplication;

    public void clickTheJobTitle(String jobTitle) {
        logger.info("Attempting to select the job title: {}", jobTitle);
        boolean jobFound = false;
        for (WebElement element : listJobTitles) {
            if (element.getText().equalsIgnoreCase(jobTitle)) {
                element.click();
                jobFound = true;
                logger.info("Job title '{}' selected successfully.", jobTitle);
                break;
            }
        }
        if (!jobFound) {
            logger.warn("Job title '{}' not found in the available options.", jobTitle);
            throw new IllegalArgumentException("Job title not found: " + jobTitle);
        }
    }

    public void submitForm() {
        logger.info("Attempting to submit the form.");
        try {
            btnSubmit.click();
            logger.info("Form submitted successfully.");
        } catch (Exception e) {
            logger.error("Error occurred while submitting the form: {}", e.getMessage());
        }
    }

    public void verifySuccessMessageVisibility() {
        logger.info("Verifying the visibility of the success message.");
        try {
            Tech2nMethods.waitForVisibility(txtSuccessMsjApplication);
            Assert.assertTrue(txtSuccessMsjApplication.isDisplayed());
            logger.info("Success message is visible.");
            Tech2nMethods.takeScreenshot("@2NTECH_JobApplication_SuccessMessage");
        } catch (Exception e) {
            logger.error("Success message is not visible or an error occurred: {}", e.getMessage());
        }
    }

    public void verifyJobApplicationSuccessUrl() {
        logger.info("Verifying the job application success URL.");
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(URL_OF_SUCCESS_JOB_APPLICATION)) {
            logger.info("Current URL matches the expected success URL: {}", currentUrl);
            Tech2nMethods.takeScreenshot("@2NTECH_JobApplication_SuccessUrl");
        } else {
            logger.error("URL mismatch. Expected: {}, but got: {}", URL_OF_SUCCESS_JOB_APPLICATION, currentUrl);
            Assert.assertEquals(URL_OF_SUCCESS_JOB_APPLICATION, currentUrl);
        }
    }
}

