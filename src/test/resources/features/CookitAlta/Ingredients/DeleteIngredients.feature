@Test
Feature: Testing API Post Ingredient
  Scenario: Delete ingredient with valid data
    Given Delete ingredient with valid recipe id 205 and ingredient id 133
    When Send request delete ingredients
    Then Status code should be 200 ok

  Scenario: Delete ingredient with invalid data
    Given Delete ingredient with invalid recipe id "abc" and ingredient id "$%^&"
    When Send request delete ingredients
    Then Status code should be 400 bad request