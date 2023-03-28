@Test
  Feature: Testing API Post Steps
    Scenario: Put steps with valid data
      Given Put step with valid data recipe 18 steps 29
      When Send request put step
      Then Status code should be 200 OK
      And Validate json schema put step