
#Feature: Testing API DELETE Likes
#  Scenario: DELETE user's Unlike recipe
#    Given Delete user's Unlike recipe valid id 1
#    When Send request delete user's Unlike
#    Then Status code should be 204 No Content
#
#  Scenario: DELETE user's Unlike recipe with invalid path
#    Given Delete user's Unlike recipe valid id "satu"
#    When Send request delete user's Unlike
#    Then Status code should be 400 Bad_Request
