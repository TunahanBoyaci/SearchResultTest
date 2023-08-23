Feature: SearchResultTest
  Scenario: SearchResultTest
    Given Navigate to the page
    When User type "teddy bear" into the search box
    And Click on the search button
    Then "We've got 297 results for 'teddy bear'" is displayed