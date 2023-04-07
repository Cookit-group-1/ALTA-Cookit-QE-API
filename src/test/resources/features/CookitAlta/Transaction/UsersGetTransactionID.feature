@Test
Feature: Get Users transaction ID
  @Test @PositiveCase
  Scenario: Get users transaction ID with valid token
    Given Get users data transaction ID with valid token
    When Get users data request transaction ID
    Then Should return status code 200
#    And Validate json schema users transaction ID



  @Test @NegativeCase
  Scenario: Get users transaction ID with invalid token
    Given Get users data transaction ID with invalid token
    When Get users data request transaction ID
    Then Should return status code 401
