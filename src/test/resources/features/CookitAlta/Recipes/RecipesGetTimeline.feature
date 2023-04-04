@Test
Feature: Testing API GET Recipes Timeline
  Scenario: GET recipes timeline without parameter
    Given Get recipes timeline without parameter
    When Send request get recipes timeline without parameter
    Then Status code should be 200 OK
    And Validate get recipes timeline json schema
