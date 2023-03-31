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

public class UsersGETSinggleUserStepDef {

    @Steps
    UsersAPI usersAPI;

    @Given("Get all data users with {string} as path")
    public void getAllDataUsersWithAsPath(String path) {
        usersAPI.getAllDataUser(path);
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

}
