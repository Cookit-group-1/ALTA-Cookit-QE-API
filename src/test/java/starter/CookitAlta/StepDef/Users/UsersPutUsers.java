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

public class UsersPutUsers {
    @Steps
    UsersAPI usersAPI;


    @Given("Update data users with valid token")
    public void updateDataUsersWithValidToken() {
        File update = new File(Constant.JSON_REQUEST + "Users/UsersPutUser.json");
        usersAPI.getUpdateUsers(update);
    }

    @When("Send data users Update request")
    public void sendDataUsersUpdateRequest() {
        usersAPI.sendUpdateUsers(Constant.BEARER_TOKEN);
    }

    @And("Validate json schema data users Update")
    public void validateJsonSchemaDataUsersUpdate() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Users/ResponsesUsersUpdate.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Update data users with invalid token")
    public void updateDataUsersWithInvalidToken() {
        File update = new File(Constant.JSON_REQUEST + "Users/UsersPutUser.json");
        usersAPI.getUpdateUsersInvalid(update);
    }

    @When("Send data users Update invalid token")
    public void sendDataUsersUpdateInvalidToken() {
        usersAPI.sendUpdateUsersInvalid(Constant.INVALID_TOKEN);
    }




}
