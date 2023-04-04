
#  Feature: Testing API Post Steps
#    Scenario: insert new steps with valid data
#      Given Post step with valid data parameter 18
#      When Send request post steps
#      Then Status code should be 201 Created
#      And Validate json schema post step
#
#    Scenario: Post steps with invalid parameter
#      Given Post step with invalid paramater 14
#      When Send request post steps
#      Then Status code should be 400 Bad Request
#      And Validate json schema invalid post step
#
#    Scenario: Post steps register with empty value json body
#      Given Post step with invalid json body and valid id 18
#      When Send request post steps
#      Then Status code should be 400 Bad Request
#      And Validate json schema invalid post step