@Test
Feature: Testing API GET Recipes
  Scenario: GET recipes without parameter
    Given Get recipes with parameter
    When Send request get recipes
    Then Status code should be 200 OK
    And Validate get recipes json schema

  Scenario: GET recipes with parameter
    Given Get recipes with parameter <id>
    When Send request get recipes
    Then Status code should be 400 Bad_Request
