@Test
Feature: Testing API post Login
  Scenario: Login for user with valid data json
    Given Login with valid data json
    When Send request post Login
    Then Status code should be 200 OK
    And Validate json schema post Login

  Scenario: Login with valid data json without username
    Given Login with valid data json without username
    When Send request post Login
    Then Status code should be 400 Bad_Request

  Scenario: Login with valid data json without password
    Given Login with valid data json without password
    When Send request post Login
    Then Status code should be 400 Bad_Request

  Scenario: Login with valid data json invalid data unregister
    Given Login with valid data json invalid data unregister
    When Send request post Login
    Then Status code should be 400 Bad_Request