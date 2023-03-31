@Testshidiq
@Users
Feature: Put Users

  @Test @PositiveCase
  Scenario Outline: Update users with valid token and valid form-data
    Given Put users request for update data user with "users" as path
    When Add users with "<username>" as nama, "<bio>" as bio, "<email>" as email and "<password>" as password
    Given Update users request
    Then Should return status code 200
    And Validate json schema update data users
    Examples:
      | username    | bio               | email                       | password  |
      | Tim Qe Joss | I love cooking to | intanpermana@example123.com | Cookit123 |



  @Test @PositiveCase
  Scenario: Update users with valid token and valid form-data
    Given Put users request for update data user with "users" as path
    When Update users with "Tim Qe Joss" as nama, "I love cooking to" as bio, "intanpermana@example123.com" as email and "Cookit123" as password
    Given Update users request
    Then Should return status code 401