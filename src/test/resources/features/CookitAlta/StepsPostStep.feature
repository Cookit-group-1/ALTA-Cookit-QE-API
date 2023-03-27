@Steps
  Feature: Testing API Post Steps
    Scenario: insert new steps with valid data
      Given Post step with valid data parameter 1
      When Send request post steps
      Then Status code should be 201 Created
      And Validate json schema post step
