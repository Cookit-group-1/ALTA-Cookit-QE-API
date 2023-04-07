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

public class UserdUpgradeUsersStepdef {
    @Steps
    UsersAPI usersAPI;

    @Given("Upgrade data users with valid token")
    public void upgradeDataUsersWithValidToken() {
        File upgrade = new File(Constant.JSON_REQUEST + "Users/UsersUpdateUsers.json");
        usersAPI.getUpgradeUsers(upgrade);
    }

    @When("Send data users Upgrade request")
    public void getDataUsersUpgradeRequest() {
        usersAPI.sendUpdate(Constant.BEARER_TOKEN);
    }

    @And("Validate json schema data users Upgrade")
    public void validateJsonSchemaDataUsersUpgrade() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Users/ResponsesUsersUpdate.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


    // INVALID
    @Given("Upgrade data users with invalid token")
    public void upgradeDataUsersWithInvalidToken() {
        File upgrade = new File(Constant.JSON_REQUEST + "Users/UsersUpdateUsers.json");
        usersAPI.getUpgradeUsersInvalid(upgrade);

    }

    @When("Send data users Upgrade invalid token")
    public void sendDataUsersUpgradeInvalidToken() {
        usersAPI.sendUpdateInvalid(Constant.INVALID_TOKEN);
    }
    // END INVALID


}
