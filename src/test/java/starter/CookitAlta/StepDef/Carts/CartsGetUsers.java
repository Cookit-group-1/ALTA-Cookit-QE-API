package starter.CookitAlta.StepDef.Carts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Carts.CartsGetAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class CartsGetUsers {

    @Steps
    CartsGetAPI cartsGetAPI;


    @Given("Get list users carts")
    public void getListUsersCarts() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "Carts/CartsGetUsers.json");
        cartsGetAPI.setCartsUsers(jsonRequest);
    }

    @When("Send request get users carts")
    public void sendRequestGetUsersCarts() {
        SerenityRest.when().get(CartsGetAPI.GET_CARTS_USERS);
    }

    @And("Validate json schema users carts")
    public void validateJsonSchemaUsersCarts() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Carts/CartsGetUsersValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }
}
