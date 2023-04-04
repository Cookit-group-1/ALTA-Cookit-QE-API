@Test
Feature: Testing API Post Image
  #positive
  Scenario: Post image with valid id and json file
    Given Post image with valid id recipe 18
    When Send post image
    Then Status code should be 201 created
    And Validate json schema post image valid

  #negative
  Scenario: Post image with invalid id and valid json file
    Given Post image with valid id recipe "abc"
    When Send post image
    Then Status code should be 400 bad request
    And Validate json schema post invalid image

  #negative
  Scenario: Post image with valid id empty json
    Given Post image with valid id recipe 18 and empty json
    When Send post image
    Then Status code should be 400 bad request
    And Validate json schema invalid post image empty

