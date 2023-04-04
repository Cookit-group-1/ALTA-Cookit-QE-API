@Test
#  Feature: Testing API post register
#    Scenario: Register with valid data json
#      Given register with valid data json
#      When Send request post register
#      Then Status code should be 201 Created
#      And Validate json schema post register
#
#  Scenario: Create new user without username
#    Given register with valid data json without username
#    When Send request post register
#    Then Status code should be 400 Bad_Request
#
#  Scenario: Create new user without email
#    Given register with valid data json without email
#    When Send request post register
#    Then Status code should be 400 Bad_Request
#
#  Scenario: Create new user without email
#    Given register with valid data json without password
#    When Send request post register
#    Then Status code should be 400 Bad_Request