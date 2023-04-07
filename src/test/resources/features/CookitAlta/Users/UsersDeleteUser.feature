@Login
Feature: Delete data users
  @Test @PositiveCase
  Scenario: Delete data users with valid token
    Given Delete data users with valid token
    When Delete data users request
    Then Should return status code 200
    And Validate json schema Delete users

  @Test @NegativeCase
  Scenario: Delete data users with invalid token
    Given Delete data users with invalid token
    When Delete data users request
    Then Should return status code 401
