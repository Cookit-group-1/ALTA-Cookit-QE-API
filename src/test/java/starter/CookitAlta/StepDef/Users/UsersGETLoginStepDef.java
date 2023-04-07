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

public class UsersGETLoginStepDef {
    @Steps
    UsersAPI usersAPI;


    // LOGIN SCENARIO
    @Given("Post user login with valid users")
    public void postLoginvalidUser(){
        SerenityRest.when().get(UsersAPI.POST_LOGIN_USERS);
    }

    @When("Send request login user")
    public void sendRequestLoginUser() {
        File json = new File(Constant.JSON_REQUEST+"Users/LoginUsers.json");
        usersAPI.postLogin(json);

    }

    @And("Validate json schema Guru Login")
    public void validateJsonSchemaGuruLogin() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Users/ResponsesPOSTLoginUsers.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    // END LOGIN SCENARIO


}
