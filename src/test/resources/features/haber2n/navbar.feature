@SmokeTest2NHABER @2NHABER @NavBarValidation
Feature: Navbar Navigation Validation
  As a visitor
  I want to navigate through the website's navbar
  So that I can verify all main and submenu links are functional

  @MainMenuValidation
  Scenario: Validate main menu navigation
    When the user clicks each main menu item and validates the page loads and matches the title and heading

  @SubMenuValidation
  Scenario: Validate submenu navigation
    When the user clicks each submenu item and validates the page loads and matches the title and heading
