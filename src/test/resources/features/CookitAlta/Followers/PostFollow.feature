@Test
  Feature: Testing API Post Follow
    Scenario: Post followers with valid json body
      Given Post follow with valid data json
      When Send request post follow
      Then Status code should be 201 Created
      And Validate json schema post follow

    Scenario: Post followers with empty json body
      Given Post follow with invalid data json
      When Send request post follow
      Then Status code should be 400 Bad Request
      And Validate json schema invalid post follow

    Scenario: Post followers with string value json body
      Given Post follow with invalid value data json
      When Send request post follow
      Then Status code should be 400 Bad Request
      And Validate json schema invalid post follow