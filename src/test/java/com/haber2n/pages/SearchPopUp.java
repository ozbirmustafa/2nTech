package com.haber2n.pages;

import com.haber2n.utilities.Haber2nMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPopUp extends AllPagesHaber2n {

    @FindBy(xpath = "//input[@name='s']")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[@class='elementor-widget-cmsmasters-search__form-icon']")
    private WebElement btnSearch;

    public void sendKeysSearchInput(String text) {
        inputSearch.sendKeys(text);
    }

    public void submitTheSearch( ) {
        Haber2nMethods.clickWithJS(btnSearch);
    }
}
