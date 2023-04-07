@Testshidiq
Feature: Get Users Who Following
  @Test @PositiveCase
  Scenario: Get users following with valid token
    Given Get users data following with valid token
    When Get users data request following
    Then Should return status code 200
    And Validate json schema users follower

  @Test @NegativeCase
  Scenario: Get users following with invalid token
    Given Get users data following with invalid token
    When Get users data request following
    Then Should return status code 401

  @Test @NegativeCase
  Scenario: Get users following without token
    Given Get users data following without token
    When Get users data request following
    Then Should return status code 401