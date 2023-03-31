@Test
  Feature: Testing API Post Follow
    Scenario: Post followers with valid parameter
      Given Post follow with valid id 18
      When Send request post follow
      Then Status code should be 201 Created
      And Validate json schema post follow

    Scenario: Post followers with invalid parameter
      Given Post follow with invalid id 1000
      When Send request post follow
      Then Status code follow should be 400 Bad Request
      And Validate json schema invalid post follow