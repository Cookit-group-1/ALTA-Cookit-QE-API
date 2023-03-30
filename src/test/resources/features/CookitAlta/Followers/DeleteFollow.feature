@Test
  Feature: Testing API Delete Follow
    Scenario: Delete follow with valid parameter
      Given Delete follow with valid data follow id 2
      When Send request delete follow
      Then Status code should be 200 OK

    Scenario: Delete follow with invalid parameter
      Given Delete follow with invalid data follow id 100
      When Send request delete follow
      Then Status code should be 400 Bad Request