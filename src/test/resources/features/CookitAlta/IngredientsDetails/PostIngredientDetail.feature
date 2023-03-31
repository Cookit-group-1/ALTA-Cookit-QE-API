@Test
  Feature: Testing API Post Ingredient Detail
    Scenario: Post ingredients details with valid id
      Given Post ingredient details with valid id recipe 18 ingredient 1
      When Send post ingredien details
      Then Status code should be 201 Created
      And Validate json schema post ingredient detail

    Scenario: Post ingredients details with invalid id
      Given Post ingredient details with valid id recipe 18 ingredient 100
      When Send post ingredien details
      Then Status code should be 400 Bad Request
      And Validate json schema invalid ingredient detail

    Scenario: Post ingredients details with empty json
      Given Post ingredient details with valid id recipe 18 ingredient 1 and empty json
      When Send post ingredien details
      Then Status code should be 400 Bad Request
      And Validate json schema invalid ingredient detail