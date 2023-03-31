@Test
Feature: Get All Users
  @Test @PositiveCase
  Scenario: Get all data users with valid url
    Given Get all data users with "users" as path
    When Get all users request
    Then Should return status code 200
    And Validate json schema all data users

  @Test @NegativeCase
  Scenario: Get all data users with invalid url
    Given Get all data users with "users" as path
    When Get all users request
    Then Should return status code 404