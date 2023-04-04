  @Test
  Feature: Testing API Put Image
  #positive
  Scenario: Put image with valid id and json file
    Given Put image with valid id recipe 18 and id image 27
    When Send put image
    Then Status code should be 200 ok
    And Validate json schema put image valid

  #negative
  Scenario: Put image with invalid id and valid json file
    Given Put image with valid id recipe "abc" and id image "$%^&"
    When Send put image
    Then Status code should be 400 bad request
    And Validate json schema put invalid image

  #negative
  Scenario: Put image with valid id empty json
    Given Put image with valid id recipe 18 and id image 27 and empty json
    When Send put image
    Then Status code should be 400 bad request
    And Validate json schema invalid put image empty

