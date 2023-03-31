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

public class UsersPUTUsers {
    @Steps
    UsersAPI usersAPI;

    @Given("Put users request for update data user with {string} as path")
    public void putUsersRequestForUpdateDataUeser(String path) {
        {
            usersAPI.putDataUser(path);
        }
    }

    @When("Add users with {string} as nama, {string} as bio, {string} as email and {string} as password")
    public void addUsersWithAsNamaAsBioAsEmailAndAsPassword(String username, String bio, String email, String password) {
        usersAPI.setPutUsers(username, bio, email, password);
    }

    @Given("Update users request")
    public void updateUsersRequest() {
        SerenityRest.when().put(UsersAPI.PUT_USERS);
    }

    @And("Validate json schema update data users")
    public void validateJsonSchemaUpdateDataUsers() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Users/ResponesesPUTUser.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


    @When("Update users with {string} as nama, {string} as bio, {string} as email and {string} as password")
    public void updateUsersWithAsNamaAsBioAsEmailAndAsPassword(String username, String bio, String email, String password) {
        usersAPI.setPutUsersInvalid(username, bio, email, password);
    }


}
