package com.haber2n.pages;

import org.openqa.selenium.support.PageFactory;

import static com.haber2n.stepDefinitions.Haber2nHooks.driver;

public class AllPagesHaber2n {

    public AllPagesHaber2n() {
        PageFactory.initElements(driver,this);
    }

    private HomePage homePage;
    private NavBar navBar;
    private SearchPopUp searchPopUp;
    private SearchResultsPage searchResultsPage;

    public HomePage homePage(){
        if (homePage == null){
            homePage = new HomePage();
        }
        return homePage;
    }

    public NavBar navBar(){
        if (navBar == null){
            navBar = new NavBar();
        }
        return navBar;
    }

    public SearchPopUp searchPopUp( ) {
        if (searchPopUp == null){
            searchPopUp = new SearchPopUp();
        }
        return searchPopUp;
    }

    public SearchResultsPage searchResultsPage( ) {
        if (searchResultsPage == null){
            searchResultsPage = new SearchResultsPage();
        }
        return searchResultsPage;
    }
}
