@Test
Feature: Testing API Post Ingredients
  #positive
  Scenario: Post ingredients with valid id and json file
    Given Post ingredients with valid id recipe 18
    When Send post ingredients
    Then Status code should be 201 created
    And Validate json schema post ingredients

  #negative
  Scenario: Post ingredients with invalid id and valid json file
    Given Post ingredients with invalid id recipe "abc"
    When Send post ingredients
    Then Status code should be 400 bad request
    And Validate json schema invalid ingredients

  #negative
  Scenario: Post ingredients details with empty json
    Given Post ingredient with valid id recipe 18 and empty json
    When Send post ingredients
    Then Status code should be 400 bad request
    And Validate json schema invalid ingredients

