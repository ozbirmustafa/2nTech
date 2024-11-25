package com.haber2n.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AllPagesHaber2n {

    @FindBy(xpath = "//div[contains(@class, 'elementor-widget-cmsmasters-search__popup-trigger-inner')]")
    private WebElement btnSearch;

    public void clickSearchButton(){
        btnSearch.click();
    }

}
