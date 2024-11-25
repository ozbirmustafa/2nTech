package com.haber2n.utilities;

import com.haber2n.pages.AllPagesHaber2n;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import static com.haber2n.stepDefinitions.Haber2nHooks.driver;

public class Haber2nMethods extends AllPagesHaber2n {

    private static final int timeOut = 10;
    private static WebDriverWait webDriverWait;
    private static Actions actions;
    private static JavascriptExecutor jsExecutor;

    public static void takeScreenshot(String scenarioName) {
        scenarioName = scenarioName.replaceAll("[\\/:*?\"<>|]", "_");

        scenarioName = scenarioName
                .replace("İ", "I").replace("ı", "i")
                .replace("Ç", "C").replace("ç", "c")
                .replace("Ö", "O").replace("ö", "o")
                .replace("Ş", "S").replace("ş", "s")
                .replace("Ü", "U").replace("ü", "u")
                .replace("Ğ", "G").replace("ğ", "g");

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "screenshots/" + scenarioName + "_" + timestamp + ".png";

        File destFile = new File(screenshotPath);

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void wait(int second){
        try {
            Thread.sleep(1000L * second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the visible text from a list of web elements.
     * @param webElementList the list of {@link WebElement}
     */
    public static ArrayList<String> getTextsFromWebListElements(List<WebElement> webElementList) {
        return webElementList.stream()
                .map(WebElement::getText)
                .filter(text -> text != null && !text.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void hoverToElement(WebElement element){
        actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void verifyHeadingTitleEquals(String expectedTitle){
        WebElement headingTitle = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(expectedTitle, headingTitle.getText());
    }

    public static void waitForPageLoad() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        jsExecutor = (JavascriptExecutor) driver;
        webDriverWait.until(webDriver ->
                jsExecutor.executeScript("return document.readyState").equals("complete")
        );
    }

    public static void waitForVisibility(WebElement element) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        jsExecutor = (JavascriptExecutor) driver;
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }




    public static void clickWithJS(WebElement element) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public static void scrollIntoViewJS(WebElement element) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollAndClickJS(WebElement element) {
        scrollIntoViewJS(element);
        clickWithJS(element);
    }









}
