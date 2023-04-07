@Test
Feature: Update password data users
@Test @PositiveCase
Scenario: Update password users with valid token
Given Update password users with valid token
When Send data users password request
Then Should return status code 200
And Validate json schema data users password


@Test @NegativeCase
Scenario: Update password users with invalid token
Given Update password users with invalid token
When Send data users password invalid token
Then Should return status code 401
