@Test
Feature: Post Users transaction
  @Test @PositiveCase
  Scenario: Create users transaction with valid token
    Given Create users data transaction with valid token
    When Create users data request transaction
#    Then Should return status code 201
#    And Validate json schema Create users transaction



  @Test @NegativeCase
  Scenario: Create users transaction with invalid token
    Given Create users data transaction with invalid token
    When Create users data request transaction
    Then Should return status code 401