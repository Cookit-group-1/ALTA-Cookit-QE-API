@Test
#Feature: Testing API PUT Recipes Users Recipes
#  Scenario: PUT Recipes Update user's recipe with valid path
#    Given Put Recipes Update user's recipes valid json with id 1
#    When Send request put update recipes
#    Then Status code should be 201 Created
#    And Validate put update recipes json schema
#
#  Scenario: PUT Recipes Update user's recipe without field name
#    Given Put Recipes Update user's recipes valid json without field name json
#    When Send request put update recipes
#    Then Status code should be 400 Bad_Request
#
#  Scenario: PUT Recipes Update user's recipe without field description
#    Given Put Recipes Update user's recipes valid json without field description json
#    When Send request put update recipes
#    Then Status code should be 400 Bad_Request
#
#  Scenario: PUT Recipes Update user's recipe with empty field name
#    Given Put Recipes Update user's recipes valid json with empty field name json
#    When Send request put update recipes
#    Then Status code should be 400 Bad_Request
#
#  Scenario: PUT Recipes Update user's recipe with empty field description
#    Given Put Recipes Update user's recipes valid json with empty field description json
#    When Send request put update recipes
#    Then Status code should be 400 Bad_Request
