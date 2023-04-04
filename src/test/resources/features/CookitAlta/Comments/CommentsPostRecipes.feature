@Test
Feature: update recipes comment
    Scenario: Insert new recipes comment id
      Given Insert new recipes comment id 51
      When Send request update recipes comment
      Then Status code should be 201 Created
      And Validate json schema comments post recipes

    Scenario: Insert new recipes comment without fill field comment
      Given Insert without fill field comment id 51
      When Send request post insert new recipes comment without field comment
      Then Status code should be 400 Bad Request


