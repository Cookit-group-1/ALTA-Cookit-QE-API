@Test
Feature: Testing API POST Recipes Users Recipes
  Scenario: POST Recipes Insert new user's recipe
    Given post Recipes Insert new user's recipe valid json
    When Send request post new user's recipe
    Then Status code should be 201 Created
    And Validate pos recipes json schema

  Scenario: POST Recipes Create new user without name
    Given post Recipes Insert new user's recipe without name json
    When Send request post new user's recipe
    Then Status code should be 400 Bad_Request

  Scenario: POST Recipes Create new user without description
    Given post Recipes Insert new user's recipe without description json
    When Send request post new user's recipe
    Then Status code should be 400 Bad_Request

  Scenario: POST Recipes Create new user without Fill Field name
    Given post Recipes Insert new user's recipe without Fill Field name json
    When Send request post new user's recipe
    Then Status code should be 400 Bad_Request

  Scenario: POST Recipes Create new user without Fill Field description
    Given post Recipes Insert new user's recipe without Fill Field description json
    When Send request post new user's recipe
    Then Status code should be 400 Bad_Request

  Scenario: POST Recipes Create new user without all Fill Field
    Given post Recipes Insert new user's recipe without all Fill Field json
    When Send request post new user's recipe
    Then Status code should be 400 Bad_Request
