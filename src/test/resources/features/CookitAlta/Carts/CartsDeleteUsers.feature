@Test
Feature: Delete users carts
  Scenario: delete users cart
    Given Delete users cart id 76
    When Send request delete users cart
    Then Status code should be 200 OK

  Scenario: delete users cart invalid id
    Given Delete users cart invalid id 1000
    When Send request delete users cart invalid
    Then Status code should be 400 Bad Request
