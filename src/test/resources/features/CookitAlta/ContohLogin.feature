Feature: Login user
  @Tugas #PositiveCase

  Scenario: Lsogin with valid username and password
    Given Lsogins with valid JSON
    When Ssend request post to login
    Then Sstatus code should be 200 OK
    And Vsalidate json schema success login

  @Tugas #NegativeCase
  Scenario: Login with valid username and empty password
    Given Lsogin with invalid JSON
    When Ssend request post to login
    Then Sshould return status code 400
    And Rsesponse body message "Invalid credentials"
    And Vsalidate json schema failed login