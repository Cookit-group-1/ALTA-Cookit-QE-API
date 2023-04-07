package starter.CookitAlta.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Transaction.TransactionApi;
import starter.CookitAlta.CookitAPI.Users.UsersAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class UsersPutPasswordUsers {
    @Steps
    UsersAPI usersAPI;

    // Update Password
    @Given("Update password users with valid token")
    public void updatePasswordUsersWithValidToken() {
        File update = new File(Constant.JSON_REQUEST + "Users/PutUsersPassword.json");
        usersAPI.putPassword(update);
    }

    @When("Send data users password request")
    public void sendDataUsersPasswordRequest() {
        usersAPI.putPasswordUsers(Constant.BEARER_TOKEN);
    }

    @And("Validate json schema data users password")
    public void validateJsonSchemaDataUsersPassword() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Users/ResponsesPutPassword.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Update password users with invalid token")
    public void updatePasswordUsersWithInvalidToken() {
        usersAPI.putPasswordUsers(Constant.INVALID_TOKEN);
    }

    @When("Send data users password invalid token")
    public void sendDataUsersPasswordInvalidToken() {
        usersAPI.putUsersPasswordWhitoutToken();
    }
}
