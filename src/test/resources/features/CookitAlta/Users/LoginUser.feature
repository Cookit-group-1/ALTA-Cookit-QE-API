@Login
Feature: Login User
  @Test @PositiveCase
  Scenario: Login with valid users JSON
    Given Post user login with valid users
    When Send request login user
    Then Should return status code 200
    And Validate json schema Guru Login