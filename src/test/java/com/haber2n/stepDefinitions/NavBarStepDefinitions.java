package com.haber2n.stepDefinitions;

import com.haber2n.pages.AllPagesHaber2n;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NavBarStepDefinitions extends AllPagesHaber2n {

    private static final Logger logger = LogManager.getLogger(NavBarStepDefinitions.class);

    @When("the user clicks each main menu item and validates the page loads and matches the title and heading")
    public void theUserClicksEachMainMenuItemAndValidatesThePageLoadsAndMatchesTheTitleAndHeading() {
        logger.info("User is validating main menu items.");
        navBar().validateNavBar();
        logger.info("Main menu items validated successfully and page titles/headers match.");
    }

    @When("the user clicks each submenu item and validates the page loads and matches the title and heading")
    public void theUserClicksEachSubmenuItemAndValidatesThePageLoadsAndMatchesTheTitleAndHeading() {
        logger.info("User is validating submenu items.");
        navBar().validateSubMenus();
        logger.info("Submenu items validated successfully and page titles/headers match.");
    }

}
