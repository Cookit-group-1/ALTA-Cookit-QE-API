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

public class UsersGetFollowerStepdef {
    @Steps
    UsersAPI usersAPI;

    @Given("Get users data follower with valid token")
    public void getUsersDataFollowerWithValidToken() {
        usersAPI.getFollower(Constant.BEARER_TOKEN);
    }

    @When("Get users data request follower")
    public void getUsersDataRequest() {
        SerenityRest.when().get(UsersAPI.USERS_FOLLOWER);
    }

    @And("Validate json schema users follower")
    public void validateJsonSchemaUsersFollower() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Users/ResponsesUsersFollower.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get users data follower with invalid token")
    public void getUsersDataFollowerWithInvalidToken() {
        usersAPI.getFollower(Constant.INVALID_TOKEN);
    }

    @Given("Get users data follower without token")
    public void getUsersDataFollowerWithoutToken() {
        usersAPI.getWithoutokenFollower();
    }
}
