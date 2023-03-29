@Test
Feature: Testing API GET Recipes
  Scenario: GET recipes without parameter
    Given Get recipes without parameter
    When Send request get recipes without parameter
    Then Status code should be 200 OK
    And Validate get recipes json schema

  Scenario: GET recipes with parameter
    Given Get recipes with parameter 1
    When Send request get recipes
    Then Status code should be 400 Bad_Request

  Scenario: GET recipes with invalid parameter
    Given Get recipes with invalid parameter "miakhalifa"
    When Send request get recipes
    Then Status code should be 400 Bad_Request

  Scenario: GET recipes with invalid parameter more than page
    Given Get recipes with invalid parameter more than page 45678
    When Send request get recipes
    Then Status code should be 400 Bad_Request