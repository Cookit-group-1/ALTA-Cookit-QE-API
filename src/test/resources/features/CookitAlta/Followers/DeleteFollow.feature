@Test
  Feature: Testing API Delete Follow
    Scenario: Delete user with valid data
      Given Delete follow with valid data follow id 2
      When Send request delete follow
      Then Status code should be 200 OK