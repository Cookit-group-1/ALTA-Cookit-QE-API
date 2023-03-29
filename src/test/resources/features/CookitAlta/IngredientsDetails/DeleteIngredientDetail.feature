@Test
  Feature: Testing API Post Ingredient Detail
    Scenario: Delete ingredient details with valid data
      Given Delete ingredient details with valid recipe 18 details 13
      When Send request delete ingredients detail
      Then Status code should be 200 OK

    Scenario: Delete ingredient details with invalid id
      Given Delete ingredient details with invalid recipe 17 details 18
      When Send request delete ingredients detail
      Then Status code should be 400 Bad Request

    Scenario: Delete ingredient details with invalid ingredient id
      Given Delete ingredient details with invalid recipe 18 details 3000
      When Send request delete ingredients detail
      Then Status code should be 400 Bad Request