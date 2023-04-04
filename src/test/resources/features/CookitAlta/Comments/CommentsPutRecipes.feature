@Test
Feature: Put comment
  Scenario: update recipes comment
    Given Put update recipes id 18 comment id 51
    When Send request put recipes comment
    Then Status code put should be 200 OK

  Scenario: update recipes comment without fill massage body json
    Given Put update invalid recipes id 18 comment id 51
    When Send request put recipes comment
    Then Status code should be 400 Bad Request

  Scenario: update recipes comment without body json
    Given Put update without body json recipes id 18 comment id 51
    When Send request put recipes comment
    Then Status code should be 400 Bad Request

