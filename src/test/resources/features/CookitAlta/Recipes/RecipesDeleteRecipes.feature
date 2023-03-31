@Test
Feature: Testing API DELETE recipe
  Scenario: DELETE user's recipe
    Given Delete user's recipe valid id 1
    When Send request delete user's recipe
    Then Status code should be 204 No Content

  Scenario: DELETE user's recipe with invalid path
    Given Delete user's recipe valid id "satu"
    When Send request delete user's recipe
    Then Status code should be 400 Bad_Request
