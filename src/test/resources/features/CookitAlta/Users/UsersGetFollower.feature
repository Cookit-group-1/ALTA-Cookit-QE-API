@Test
Feature: Get Users follower
  @Test @PositiveCase
  Scenario: Get users follower with valid token
    Given Get users data follower with valid token
    When Get users data request follower
    And Validate json schema users follower
    Then Should return status code 200


  @Test @NegativeCase
  Scenario: Get users follower with invalid token
    Given Get users data follower with invalid token
    When Get users data request follower
    Then Should return status code 401

  @Test @NegativeCase
  Scenario: Get users follower without token
    Given Get users data follower without token
    When Get users data request follower
    Then Should return status code 401