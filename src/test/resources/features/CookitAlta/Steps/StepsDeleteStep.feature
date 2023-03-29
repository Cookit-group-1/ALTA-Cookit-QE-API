@Test
  Feature: Testing API Post Steps
    Scenario: Delete steps with valid data
      Given Delete steps with valid data recipe 18 steps 54
      When Send request delete step
      Then Status code should be 200 OK
      And Validate json schema delete step

    Scenario: Delete steps with valid parameter recipe id and invalid parameter step id
      Given Delete steps with valid data recipe 18 steps 53
      When Send request delete step
      Then Status code should be 400 Bad Request
      And Validate json schema delete step

    Scenario: Delete steps with invalid parameter recipe id and valid parameter step id
      Given Delete steps with valid data recipe 1 steps 17
      When Send request delete step
      Then Status code should be 400 Bad Request
      And Validate json schema delete step