@Testcarts
Feature: Put users carts
  Scenario: update users carts id
    Given Put update users carts id 181
    When Send request put update users carts
    Then Status code should be 200 OK
    And Validate json schema put update carts

  Scenario: update users cart invalid body json
    Given Put update invalid users carts id 181
    When Send request put update users carts invalid body json
    Then Status code should be 404 Not found



