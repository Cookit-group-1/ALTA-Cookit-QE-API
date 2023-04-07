@Testshidiq
Feature: Get Users transaction
  @Test @PositiveCase
  Scenario: Get users transaction with valid token
    Given Get users data transaction with valid token
    When Get users data request transaction
    And Validate json schema users transaction
    Then Should return status code 200


  @Test @NegativeCase
  Scenario: Get users transaction with invalid token
    Given Get users data transaction with invalid token
    When Get users data request transaction
    Then Should return status code 401
