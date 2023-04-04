@Test
Feature: Get Comments recipes
    Scenario: Get list of recipes comments id
      Given Comments recipes with valid data id 18
      When Send request get comments recipes
      Then Status code get should be 200 OK
      And Validate json schema comments recipes

    Scenario: Get list of recipe's comment without parameter id
      Given Get comment without parameter id
      When Send request get comment recipes without parameter id
      Then Status code get should be 404 Not found
