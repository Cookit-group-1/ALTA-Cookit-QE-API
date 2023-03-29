@Test
Feature: Testing API GET Recipes Timeline
  Scenario: GET recipes timeline with valid parameter
    Given Get recipes timeline with valid parameter 1
    When Send request get recipes timeline
    Then Status code should be 200 OK
    And Validate get recipes timeline json schema

  Scenario: GET recipes timeline without parameter
    Given Get recipes timeline without parameter
    When Send request get recipes timeline without parameter
    Then Status code should be 200 OK
    And Validate get recipes timeline json schema

  Scenario: GET recipes timeline with invalid parameter
    Given Get recipes timeline with invalid parameter "miakhalifa"
    When Send request get recipes timeline
    Then Status code should be 400 Bad_Request

  Scenario: GET recipes timeline with invalid parameter more than page
    Given Get recipes with invalid parameter more than page 45678
    When Send request get recipes timeline
    Then Status code should be 404 Not Found