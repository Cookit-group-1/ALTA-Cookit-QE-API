@Riski
Feature: Post insert new recipe steps
  Scenario: Post insert new recipe steps with valid data
    Given Insert steps with valid data parameter and json
    When Send request post to insert steps
    Then Status code should be 201 Created
    And Validate json schema
