@Test
Feature: Testing API POST Recipes Like user's recipe user
  Scenario: POST Recipes Create Like user's recipe user
    Given post Recipes Create Like user's recipe user 18
    When Send request post Like user's recipe
    Then Status code should be 200 OK

  Scenario: POST Recipes Create Like user's with invalid path
    Given post Recipes Create Like user's recipe user "satu"
    When Send request post Like user's recipe
    Then Status code should be 400 Bad_Request
