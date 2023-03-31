package starter.CookitAlta.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Users.UsersAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class UsersGETUserSearch {
    @Steps
    UsersAPI usersAPI;



    @Given("Get search data users with as key and as value")
    public void getSearchDataUsersWithAsKeyAndAsValue() {
        usersAPI.getSearch();
    }

    @When("Get search users request")
    public void getSearchUsersRequest() {
        SerenityRest.when().get(UsersAPI.GET_SEARCH_USERS);
    }

    @And("Validate json schema from get search data users")
    public void validateJsonSchemaFromGetSearchDataUsers() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Users/ResponesesGETSearchUser.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    // flow login
//    Given("I have valid credentials", () -> {
//        // Define your valid credentials here
//        username = "myusername";
//        password = "mypassword";
//    });
//
//    When("I log in to the application", () -> {
//        // Make a POST request to the login API to obtain a bearer token
//        Response response = RestAssured.given()
//                .contentType("application/json")
//                .body("{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }")
//                .post("http://myapplication.com/api/login");
//
//        // Retrieve the bearer token from the response
//        bearerToken = response.jsonPath().getString("token");
//
//        // Store the bearer token as an environment variable
//        System.setProperty("bearerToken", bearerToken);
//    });
//
//    Then("I should be logged in successfully", () -> {
//        // Use the bearer token stored in the environment variable to make authenticated API requests
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer " + System.getProperty("bearerToken"))
//                .get("http://myapplication.com/api/user");
//
//        // Verify that the response contains the expected data
//        Assert.assertEquals("OK", response.getStatusCode());
//    });
//
//    When("I log out from the application", () -> {
//        // Make a POST request to the logout API using the bearer token
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer " + System.getProperty("bearerToken"))
//                .post("http://myapplication.com/api/logout");
//
//        // Verify that the response contains the expected data
//        Assert.assertEquals("OK", response.getStatusCode());
//    });
//
//    Then("I should be logged out successfully", () -> {
//        // Attempt to make an authenticated API request using the bearer token
//        // The request should fail with a 401 Unauthorized error if the token is no longer valid
//        Response response = RestAssured.given()
//                .header("Authorization", "Bearer " + System.getProperty("bearerToken");
}
