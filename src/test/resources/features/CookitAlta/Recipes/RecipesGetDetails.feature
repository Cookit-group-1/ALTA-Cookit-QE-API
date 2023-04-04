
#Feature: Testing API GET Recipes Details
#  Scenario: GET Recipes Details with user id
#    Given Get Recipes Details with user id 18
#    When Send request get recipes details
#    Then Status code should be 200 OK
#    And Validate get recipes details json schema
#
#  Scenario: GET Recipes Details unregistered user
#    Given Get Recipes Details unregistered user 123
#    When Send request get recipes details
#    Then Status code should be 404 Not Found
#
#  Scenario: GET Recipes Details user with invalid path
#    Given Get Recipes Details user with invalid path "aoisora"
#    When Send request get recipes details
#    Then Status code should be 400 Bad_Request