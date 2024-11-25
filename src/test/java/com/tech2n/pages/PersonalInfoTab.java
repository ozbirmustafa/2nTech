package com.tech2n.pages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.tech2n.stepDefinitions.Tech2nHooks.driver;

public class PersonalInfoTab extends AllPagesTech2n {

    private static final Logger logger = LogManager.getLogger(PersonalInfoTab.class);
    private static Faker faker;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputNameSurname;

    @FindBy(xpath = "//input[@id='tcKimlik']")
    private WebElement inputTcKimlik;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement inputPhoneNumber;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='cv_field']")
    private WebElement btnCvUpload;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnNextTab;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement chboxKVKK;

    public void enterNameSurname(String fullName) {
        logger.info("Entering full name: {}", fullName);
        inputNameSurname.sendKeys(fullName);
        logger.debug("Full name '{}' entered successfully.", fullName);
    }

    public void enterTcNumber(String tcNumber) {
        logger.info("Entering TC number: {}", tcNumber);
        inputTcKimlik.sendKeys(tcNumber);
        logger.debug("TC number '{}' entered successfully.", tcNumber);
    }

    public void enterPhoneNumber(String phoneNumber) {
        logger.info("Entering phone number: {}", phoneNumber);
        inputPhoneNumber.sendKeys(phoneNumber);
        logger.debug("Phone number '{}' entered successfully.", phoneNumber);
    }

    public void enterEmail(String email) {
        logger.info("Entering email: {}", email);
        inputEmail.sendKeys(email);
        logger.debug("Email '{}' entered successfully.", email);
    }

    public void createFakeDataForUserInfo() {
        logger.info("Generating fake data for user information.");
        faker = new Faker();

        String fullName = faker.name().fullName();
        logger.info("Generated full name: {}", fullName);
        inputNameSurname.sendKeys(fullName);

        String tcKimlik = faker.number().digits(11);
        logger.info("Generated TC Kimlik: {}", tcKimlik);
        inputTcKimlik.sendKeys(tcKimlik);

        String phoneNumber = "0505" + faker.number().digits(7);
        logger.info("Generated phone number: {}", phoneNumber);
        inputPhoneNumber.sendKeys(phoneNumber);

        String email = faker.internet().emailAddress();
        logger.info("Generated email address: {}", email);
        inputEmail.sendKeys(email);

        logger.info("Fake user data generated and entered successfully.");
    }


    public void chooseEducationDegree(String educationLevel) {
        logger.info("Selecting education degree: {}", educationLevel);
        String xpath = String.format("//button[text()='%s']", educationLevel);
        driver.findElement(By.xpath(xpath)).click();
        logger.debug("Education degree '{}' selected successfully.", educationLevel);
    }

    public void uploadCv(String path) {
        logger.info("Uploading CV from path: {}", path);
        btnCvUpload.sendKeys(path);
        logger.debug("CV uploaded successfully from path: {}", path);
    }

    public void verifyKVKKCheckBoxIsSelected() {
        Assert.assertEquals("true", chboxKVKK.getAttribute("value"));
    }

    public void clickKVKKIfIsNotSelected() {
        logger.info("Checking if KVKK checkbox is not selected.");
        if (!chboxKVKK.isSelected()) {
            logger.warn("KVKK checkbox is not selected. Clicking to select.");
            chboxKVKK.click();
            logger.debug("KVKK checkbox is selected successfully.");
        } else {
            logger.info("KVKK checkbox is already selected.");
        }
    }

    public void clickNextTabButton(){
        btnNextTab.click();
    }


}
