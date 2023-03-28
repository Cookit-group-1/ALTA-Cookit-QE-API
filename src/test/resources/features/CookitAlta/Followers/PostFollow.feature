@Test
  Feature: Testing API Post Follow
    Scenario: Post followers with valid json body
      Given Post follow with valid data json
      When Send request post follow
      Then Status code should be 201 Created
      And Validate json schema post follow