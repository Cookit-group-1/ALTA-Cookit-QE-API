@Test
Feature: Testing API GET Recipes
  Scenario: GET trending without parameter
    Given Get trending without parameter
    When Send request get recipes trending without parameter
    Then Status code should be 200 OK
    And Validate get trending json schema

