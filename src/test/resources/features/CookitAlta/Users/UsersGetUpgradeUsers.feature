@Test
Feature: Upgrade data users
  @Test @PositiveCase
  Scenario: Upgrade new users with valid token
    Given Upgrade data users with valid token
    When Send data users Upgrade request
    And Validate json schema data users Upgrade
    Then Should return status code 201

  @Test @NegativeCase
  Scenario: Upgrade new users with invalid token
    Given Upgrade data users with invalid token
    When Send data users Upgrade invalid token
    Then Should return status code 401
