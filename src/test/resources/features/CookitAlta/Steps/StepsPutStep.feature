
#  Feature: Testing API Post Steps
#    Scenario: Put steps with valid data
#      Given Put step with valid data recipe 18 steps 29
#      When Send request put step
#      Then Status code should be 200 OK
#      And Validate json schema put step
#
#    Scenario: Put steps with valid parameter recipe id and invalid parameter step id
#      Given Put step with valid data recipe 18 steps 300
#      When Send request put step
#      Then Status code should be 400 Bad Request
#      And Validate json schema invalid put step
#
#    Scenario: Put steps wih valid parameter and empty json
#      Given Put step with recipe id 18 and steps id 29 and invalid json body
#      When Send request put step
#      Then Status code should be 400 Bad Request
#      And Validate json schema invalid json put step