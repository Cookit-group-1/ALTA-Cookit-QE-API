@Test
Feature: Update data users
  @Test @PositiveCase
  Scenario: Update new users with valid token
    Given Update data users with valid token
    When Send data users Update request
    Then Should return status code 200
    And Validate json schema data users Update


  @Test @NegativeCase
  Scenario: Update new users with invalid token
    Given Update data users with invalid token
    When Send data users Update invalid token
    Then Should return status code 401
