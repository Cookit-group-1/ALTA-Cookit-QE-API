package starter.CookitAlta.StepDef.Carts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Carts.CartsPutAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class CartsPutUsers {

    @Steps
    CartsPutAPI cartsPutAPI;

    @Given("Put update users carts id {int}")
    public void putUpdateUsersCarts(int id) {
        File jsonRequest = new File(Constant.JSON_REQUEST + "Carts/CartsPutUsers.json");
        cartsPutAPI.setUpdateCartsUsers(id,jsonRequest);
    }

    @When("Send request put update users carts")
    public void sendRequestPutUpdateUsersCarts() {
        SerenityRest.when().put(CartsPutAPI.PUT_UPDATE_CARTS);
    }

    @And("Validate json schema put update carts")
    public void validateJsonSchemaPutUpdateCarts() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Carts/CartsPutUsersValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
//    NEGATIVE
    @Given("Put update invalid users carts id {int}")
    public void putUpdateInvalidUsersCarts(int id) {
        File jsonRequest = new File(Constant.JSON_REQUEST + "Carts/CartsPutUsersInvalid.json");
        cartsPutAPI.setUpdateCartsUsers(id,jsonRequest);
    }

    @When("Send request put update users carts invalid body json")
    public void sendRequestPutUpdateUsersCartsInvalidBodyJson() {
        SerenityRest.when().put(CartsPutAPI.PUT_UPDATE_CARTS_INVALID);

    }
    @Then("Status code should be {int} Not found")
    public void statusCodeShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }
}
