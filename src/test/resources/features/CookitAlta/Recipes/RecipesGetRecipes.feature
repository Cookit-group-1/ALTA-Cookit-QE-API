@Test
Feature: Testing API GET Recipes
  Scenario: GET recipes without parameter
    Given Get recipes without parameter
    When Send request get recipes without parameter
    Then Status code should be 200 OK
    And Validate get recipes json schema