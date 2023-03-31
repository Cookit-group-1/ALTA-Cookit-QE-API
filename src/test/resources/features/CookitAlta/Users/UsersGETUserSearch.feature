@Test
Feature: Get Search Users
  @Test @PositiveCase
  Scenario: Get Search Users by query parameter
    Given Get search data users with as key and as value
    When Get search users request
    Then Should return status code 200
    And Validate json schema from get search data users

#  @Test @NegativeCase
#  Scenario: Get all data users with invalid url
#    Given Get all data users with "users" as path
#    When Get all users request
#    Then Should return status code 404