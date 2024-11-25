package com.haber2n.stepDefinitions;

import com.haber2n.pages.AllPagesHaber2n;
import com.haber2n.utilities.Haber2nMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchStepDefinitions extends AllPagesHaber2n {

    private static final Logger logger = LogManager.getLogger(SearchStepDefinitions.class);
    private static String articleHeader;

    @When("the user clicks the search button")
    public void theUserClicksTheSearchButton() {
        logger.info("User clicks the search button.");
        homePage().clickSearchButton();
        logger.info("Search button clicked successfully.");
    }

    @And("the user enters {string} into the search input")
    public void theUserEntersIntoTheSearchInput(String input) {
        logger.info("User enters '{}' into the search input.", input);
        searchPopUp().sendKeysSearchInput(input);
        logger.info("Successfully entered '{}' into the search input.", input);
    }

    @And("the user submits the search query")
    public void theUserSubmitsTheSearchQuery() {
        logger.info("User submits the search query.");
        searchPopUp().submitTheSearch();
        logger.info("Search query submitted successfully.");
    }

    @Then("the search results header should display {string}")
    public void theSearchResultsHeaderShouldDisplay(String expectedHeader) {
        logger.info("Verifying that the search results header displays '{}'.", expectedHeader);
        Haber2nMethods.verifyHeadingTitleEquals(expectedHeader);
        logger.info("Search results header is displayed as expected.");
    }

    @And("the user navigates to the {int}th news article")
    public void theUserNavigatesToTheThNewsArticle(int newsIndex) {
        logger.info("User is navigating to the {}th news article.", newsIndex);
        searchResultsPage().scrollToNewsByIndex(newsIndex);
        articleHeader = searchResultsPage().getArticleHeader(newsIndex);
        searchResultsPage().openNewsByIndex(newsIndex);
        logger.info("User successfully navigated to the {}th news article.", newsIndex);
    }

    @Then("the user should verify the news title matches after navigation")
    public void theUserShouldVerifyTheNewsTitleMatchesAfterNavigation() {
        logger.info("Verifying if the news title matches after navigation.");
        Haber2nMethods.verifyHeadingTitleEquals(articleHeader);
        logger.info("News title matches after navigation.");
    }
}