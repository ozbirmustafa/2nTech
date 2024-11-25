package com.haber2n.pages;

import com.common.utilities.Driver;
import com.haber2n.utilities.Haber2nMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NavBar extends AllPagesHaber2n {

    private static final Logger logger = LogManager.getLogger(NavBar.class);

    @FindBy(xpath = "//span[@class='cmsmasters-animation']//ancestor::li")
    private List<WebElement> navBarItems;

    public void validateNavBar() {
        ArrayList<String> mainMenu = setMainMenuNameAsFormat();
        String mainMenuXpath = "//span[@class='cmsmasters-animation']//ancestor::a[text()='%s']";

        for (String menu : mainMenu) {
            logger.info("Clicking on main menu: {}", menu);
            WebElement element = Driver.getDriver().findElement(By.xpath(String.format(mainMenuXpath, menu)));
            element.click();
            String title = Driver.getDriver().getTitle();
            Assert.assertTrue(title.contains(menu));
            Haber2nMethods.verifyHeadingTitleEquals(menu);
            logger.info("Main menu '{}' validated successfully.", menu);
        }
    }

    public void validateSubMenus() {
        ArrayList<String> mainMenu = setMainMenuNameAsFormat();
        String subMenuXpathTemplate = "//span[@class='cmsmasters-animation']//ancestor::a[text()='%s']//following-sibling::ul//li";
        String mainMenuXpathTemplate = "//span[@class='cmsmasters-animation']//ancestor::a[text()='%s']";

        for (String mainMenuName : mainMenu) {
            logger.info("Hovering over main menu: {}", mainMenuName);
            WebElement mainMenuElement = Driver.getDriver().findElement(By.xpath(String.format(mainMenuXpathTemplate, mainMenuName)));
            Haber2nMethods.hoverToElement(mainMenuElement);

            List<WebElement> subMenuList = Driver.getDriver().findElements(By.xpath(String.format(subMenuXpathTemplate, mainMenuName)));

            for (int i = 0; i < subMenuList.size(); i++) {
                subMenuList = Driver.getDriver().findElements(By.xpath(String.format(subMenuXpathTemplate, mainMenuName)));
                WebElement subMenuElement = subMenuList.get(i);
                String subMenuElementName = subMenuElement.getText();
                logger.info("Clicking on submenu: {}", subMenuElementName);

                subMenuElement.click();
                Haber2nMethods.waitForPageLoad();

                String pageTitle = Driver.getDriver().getTitle();
                Assert.assertTrue(pageTitle.contains(subMenuElementName));

                mainMenuElement = Driver.getDriver().findElement(By.xpath(String.format(mainMenuXpathTemplate, mainMenuName)));
                Haber2nMethods.hoverToElement(mainMenuElement);
            }
        }
    }

    private ArrayList<String> setMainMenuNameAsFormat() {
        return Haber2nMethods.getTextsFromWebListElements(navBar().navBarItems).stream()
                .map(this::convertToSentenceCase)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private String convertToSentenceCase(String text) {
        String[] words = text.toLowerCase().split(" ");
        StringBuilder sentenceCase = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                sentenceCase.append(toUpperCaseTurkish(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return sentenceCase.toString().trim();
    }

    private char toUpperCaseTurkish(char c) {
        return switch (c) {
            case 'i' -> 'İ';
            case 'ç' -> 'Ç';
            case 'ö' -> 'Ö';
            case 'ş' -> 'Ş';
            case 'ü' -> 'Ü';
            default -> Character.toUpperCase(c);
        };
    }
}
