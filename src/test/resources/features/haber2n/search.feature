@SmokeTest2NHABER @2NHABER @SearchFeature
Feature: Search and validate news details on the homepage

  As a visitor, I want to search for a keyword and navigate to a specific news article
  so that I can verify the news details dynamically.

  @SearchAndValidate
  Scenario Outline: Search for "<keyword>" and navigate to the <newsPosition>th news article
    When the user clicks the search button
    And the user enters "<keyword>" into the search input
    And the user submits the search query
    Then the search results header should display "Search Results for: <keyword>"
    And the user navigates to the <newsPosition>th news article
    Then the user should verify the news title matches after navigation

    Examples:
      | keyword  | newsPosition |
      | İstanbul | 8            |
      | Ankara   | 3            |


