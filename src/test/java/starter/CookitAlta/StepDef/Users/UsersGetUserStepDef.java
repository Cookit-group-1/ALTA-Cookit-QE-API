package starter.CookitAlta.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Users.UsersAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class UsersGetUserStepDef {

    @Steps
    UsersAPI usersAPI;

    @Given("Get all data users with token")
    public void getAllDataUsersWithAsPath() {
        usersAPI.getAllDataUser(Constant.BEARER_TOKEN);
    }

    @When("Get all users request")
    public void getAllUsersRequest()
    {
        SerenityRest.when().get(UsersAPI.GET_SINGGLE_USER);
    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate json schema all data users")
    public void validateJsonSchemaAllDataUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Users/ResponeseGetUsers.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


    @Given("Get data users without token")
    public void getDataUsersWithoutToken() {
        usersAPI.getAllDataUser(Constant.INVALID_TOKEN);
        
    }

    @Given("Get data users with invalid token")
    public void getDataUsersWithInvalidToken() {
        usersAPI.getAllDataUser();
    }
}
