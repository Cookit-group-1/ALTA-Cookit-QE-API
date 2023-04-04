
#  Feature: Testing API Delete Follow
#    Scenario: Delete follow with valid parameter
#      Given Delete follow with valid data follow id 18
#      When Send request delete follow
#      Then Status code should be 201 Created
#
#    Scenario: Delete follow with invalid parameter
#      Given Delete follow with invalid data follow id 100
#      When Send request delete follow
#      Then Status code follow should be 400 Bad Request