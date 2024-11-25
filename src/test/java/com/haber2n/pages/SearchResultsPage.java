package com.haber2n.pages;

import com.haber2n.utilities.Haber2nMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends AllPagesHaber2n {

    @FindBy(xpath = "//a[@class='cmsmasters-animation']")
    private List<WebElement> listNews;

    public void scrollToNewsByIndex(int newsIndex){
        Haber2nMethods.scrollIntoViewJS(listNews.get(newsIndex-1));
    }

    public void openNewsByIndex(int newsIndex) {
        Haber2nMethods.clickWithJS(listNews.get(newsIndex-1));
    }

    public String getArticleHeader(int newsIndex) {
        return listNews.get(newsIndex-1).getText();
    }

}
