@Test
Feature: Testing API Post Image
  Scenario: Delete image with valid data
    Given Delete image with valid recipe id 205 and image id 93
    When Send request delete image
    Then Status code should be 200 ok

  Scenario: Delete image with invalid data
    Given Delete image with invalid recipe id "abc" and image id "$%^&"
    When Send request delete image
    Then Status code should be 400 bad request

