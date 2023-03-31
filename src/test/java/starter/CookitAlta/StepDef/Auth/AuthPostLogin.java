package starter.CookitAlta.StepDef.Auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Auth.AuthAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class AuthPostLogin {
    @Steps
    AuthAPI authAPI;

    @Given("Login with valid data json")
    public void loginWithValidDataJson() {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Auth/PostLoginValidation.json");
        authAPI.setPostLoginUtama(jsonRequest);
    }

    @When("Send request post Login")
    public void sendRequestPostLogin() {
        SerenityRest.when().post(AuthAPI.POST_LOGIN_UTAMA);
    }

    @And("Validate json schema post Login")
    public void validateJsonSchemaPostLogin() {
        File JsonValidate = new File(Constant.JSON_SCHEMA+"Auth/PostLoginValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonValidate));
    }

    //negative
    @Given("Login with valid data json without username")
    public void loginWithValidDataJsonWithoutUsername() {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Auth/PostLoginWithoutUsername.json");
        authAPI.setPostLoginUtama(jsonRequest);
    }

    @Given("Login with valid data json without password")
    public void loginWithValidDataJsonWithoutPassword() {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Auth/PostLoginWithoutPassword.json");
        authAPI.setPostLoginUtama(jsonRequest);
    }

    @Given("Login with valid data json invalid data unregister")
    public void loginWithValidDataJsonInvalidDataUnregister() {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Auth/PostLoginUnregistered.json");
        authAPI.setPostLoginUtama(jsonRequest);
    }
}
