@Test
  Feature: Testing API Post Ingredient Detail
    Scenario: Put ingredient details with valid data
      Given Put ingredient details with valid id recipe 18 ingredient detail 18
      When Send put ingredien details
      Then Status code put should be 200
      And Validate json schema put ingredient detail

    Scenario: Put ingredient details with valid recip id and invalid infredient id
      Given Put ingredient details with valid id recipe 18 ingredient detail 200
      When Send put ingredien details
      Then Status code should be 400 Bad Request
      And Validate json schema put ingredient detail

    Scenario: Put ingredient details with invalid json body
      Given Put ingredient details with invalid json body recipe 18 detail 18
      When Send put ingredien details
      Then Status code should be 400 Bad Request
      And Validate json schema put ingredient detail
