package starter.CookitAlta.StepDef.Carts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Carts.CartsPostAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class CartsPostUsers {

    @Steps
    CartsPostAPI cartsPostAPI;

    @Given("Post insert new users carts")
    public void postInsertNewUsersCarts() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "Carts/CartsPostUsers.json");
        cartsPostAPI.setInsertMewUsersCarts(jsonRequest);
    }

    @When("Send request post insert new users carts")
    public void sendRequestPostInsertNewUsersCarts() {
        SerenityRest.when().post(CartsPostAPI.POST_INSERT_NEW_CARTS);
    }

    @And("Validate json schema insert new users carts")
    public void validateJsonSchemaInsertNewUsersCarts() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Carts/CartsPostUsersValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }

    @Given("Post insert invalid body json")
    public void postInsertInvalidBodyJson() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "Carts/CartsPostUsersInvalid.json");
        cartsPostAPI.setInsertMewUsersCarts(jsonRequest);
    }

    @When("Send request post insert invalid new users carts")
    public void sendRequestPostInsertInvalidNewUsersCarts() {
        SerenityRest.when().post(CartsPostAPI.POST_INSERT_NEW_CARTS);
    }
}
