@Test
Feature:  Get user carts
  Scenario: get list of users carts
    Given Get list users carts
    When Send request get users carts
    Then Status code should be 200 OK
    And Validate json schema users carts

