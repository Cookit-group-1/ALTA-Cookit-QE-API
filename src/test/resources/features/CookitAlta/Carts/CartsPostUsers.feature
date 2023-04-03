@Test
Feature: Post users carts
  Scenario: insert new users carts
    Given Post insert new users carts
    When Send request post insert new users carts
    Then Status code should be 201 Created
    And Validate json schema insert new users carts

  Scenario: insert new users cart invalid body json
    Given Post insert invalid body json
    When Send request post insert invalid new users carts
    Then Status code should be 400 Bad Request

