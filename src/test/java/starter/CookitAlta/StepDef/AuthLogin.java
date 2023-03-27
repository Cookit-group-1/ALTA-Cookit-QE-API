package starter.CookitAlta.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.AuthAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class AuthLogin {

    @Steps
    AuthAPI authApi;

    //Positive Case

    @Given("Lsogins with valid JSON")
    public void loginWithValidJSON() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/Auth/LoginValid.json");
        authApi.postLogin(jsonRequest);

    }

    @When("Ssend request post to login")
    public void sendRequestPostToLogin() {
        SerenityRest.when().post(AuthAPI.POST_LOGIN);
    }

    @And("Vsalidate json schema success login")
    public void validateJsonSchemaSuccessLogin() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Auth/SuccessLogin.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


    //Negative Case
    @Given("Lsogin with invalid JSON")
    public void loginWithInvalidJSON() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "Auth/LoginInvalid.json");
        authApi.postLogin(jsonRequest);
    }


    @Then("Sshould return status code {int}")
    public void shouldReturnStatusCode(int arg0) {
        SerenityRest.then().statusCode(arg0);
    }

    @And("Rsesponse body message {string}")
    public void responseBodyMessage(String arg0) {
    }

    @And("Vsalidate json schema failed login")
    public void validateJsonSchemaFailedLogin() {File jsonSchema = new File(Constant.JSON_SCHEMA + "Auth/FailedLogin.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Then("Sstatus code should be {int} OK")
    public void statusCodeShouldBeOK(int status) {
        SerenityRest.then().statusCode(status);
    }
}

