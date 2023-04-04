@Test
Feature: Delete comments recipes
  Scenario: delete recipes comment
    Given Delete recipes id 18 comment id 51
    When Send request delete comments recipes
    Then Status code should be 200 OK

  Scenario: delete recipes invalid comment id
    Given Delete recipes id 18 invalid comments id 1
    When Send request delete comments recipes
    Then Status code should be 400 Bad Request

  Scenario: delete recipes comment with invalid recipes id
    Given Delete invalid recipes id 2 comments id 1
    When Send request delete comments recipes
    Then Status code should be 400 Bad Request

