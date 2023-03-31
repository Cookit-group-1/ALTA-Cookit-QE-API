package starter.CookitAlta.StepDef.Auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Auth.AuthAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class AuthPostRegister {
    @Steps
    AuthAPI authAPI;

    @Given("register with valid data json")
    public void registerWithValidDataJson() {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Auth/PostRegister.json");
        authAPI.postRegister(jsonRequest);

    }

    @When("Send request post register")
    public void sendRequestPostRegister() {
        SerenityRest.when().post(AuthAPI.POST_LOGIN);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int status) {
        SerenityRest.then().statusCode(status);
    }

    @And("Validate json schema post register")
    public void validateJsonSchemaPostRegister() {
        File jsonValidate = new File(Constant.JSON_SCHEMA+"Auth/PostRegisterValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonValidate));
    }

    //negative
    @Given("register with valid data json without username")
    public void registerWithValidDataJsonWithoutUsername() {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Auth/PostRegisterWithoutUsername.json");
        authAPI.postRegister(jsonRequest);
    }

    @Then("Status code should be {int} Bad_Request")
    public void statusCodeShouldBeBad_Request(int status) { SerenityRest.then().statusCode(status);
    }

    @Given("register with valid data json without email")
    public void registerWithValidDataJsonWithoutEmail() {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Auth/PostRegisterWithoutEmail.json");
        authAPI.postRegister(jsonRequest);
    }

    @Given("register with valid data json without password")
    public void registerWithValidDataJsonWithoutPassword() {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Auth/PostRegisterWithoutPassword.json");
        authAPI.postRegister(jsonRequest);
    }
}
