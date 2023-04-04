
  Feature: Testing API Get User
    Scenario: Get user with valid data
      Given Get user with valid data
      When Send request get user
      Then Status code should be 200 OK