@Test
Feature: Testing API Put Ingredients
  #positive
  Scenario: Put ingredients with valid id and json file
    Given Put ingredients with valid id recipe 18 and ingredient id 18
    When Send put ingredients
    Then Status code should be 200 ok
    And Validate json schema put ingredients

  #negative
  Scenario: Put ingredients with invalid id and valid json file
    Given Put ingredients with invalid id recipe "abc" and id ingredient "abc"
    When Send put ingredients
    Then Status code should be 400 bad request
    And Validate json schema invalid put ingredients

  #negative
  Scenario: Put ingredients with valid id recipe and invalid id ingredient and valid json file
    Given Put ingredients with valid id recipe 18 and ingredient id "abc"
    When Send put ingredients
    Then Status code should be 400 bad request
    And Validate json schema invalid put ingredients

  #negative
  Scenario: Put ingredients with valid id and empty json
    Given Put ingredients with valid id recipe 18 and ingredient id 18 and empty json
    When Send put ingredients
    Then Status code should be 400 bad request
    And Validate json schema invalid put ingredients empty

  #negative
  Scenario: Put ingredients with invalid id and empty json
    Given Put ingredients with invalid id recipe "abc" and id ingredient "abc" and empty json
    When Send put ingredients
    Then Status code should be 400 bad request
    And Validate json schema invalid put ingredients empty


