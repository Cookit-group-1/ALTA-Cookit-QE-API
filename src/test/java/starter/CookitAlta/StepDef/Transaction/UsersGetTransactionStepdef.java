package starter.CookitAlta.StepDef.Transaction;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Users.UsersAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class UsersGetTransactionStepdef {
    @Steps
    UsersAPI usersAPI;

    @Given("Get users data following with valid token")
    public void getUsersDataFollowerWithValidToken() {
        usersAPI.getFollowing(Constant.BEARER_TOKEN);
    }

    @When("Get users data request following")
    public void getUsersDataRequest() {
        SerenityRest.when().get(UsersAPI.USERS_FOLLOWING);
    }

    @And("Validate json schema users following")
    public void validateJsonSchemaUsersFollower() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Users/ResponsesUsersFollowing.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get users data following with invalid token")
    public void getUsersDataFollowerWithInvalidToken() {
        usersAPI.getFollowing(Constant.INVALID_TOKEN);
    }

    @Given("Get users data following without token")
    public void getUsersDataFollowerWithoutToken() {
        usersAPI.getWithoutokenFollowing();
    }

    @Given("Get users data transaction with valid token")
    public void getUsersDataTransactionWithValidToken() {
    }

    @When("Get users data request transaction")
    public void getUsersDataRequestTransaction() {
    }

    @And("Validate json schema users transaction")
    public void validateJsonSchemaUsersTransaction() {
    }

    @Given("Get users data transaction with invalid token")
    public void getUsersDataTransactionWithInvalidToken() {
    }
}
