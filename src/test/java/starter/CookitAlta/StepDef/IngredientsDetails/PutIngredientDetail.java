package starter.CookitAlta.StepDef.IngredientsDetails;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.IngredientsDetails.IngredientsDetails;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class PutIngredientDetail {
    @Steps
    IngredientsDetails ingredientsDetails;

    @Given("Put ingredient details with valid id recipe {int} ingredient detail {int}")
    public void putIngredientDetailsWithValidIdRecipeIngredient(int arg0, int arg1) {
        File jsonRequest = new File(Constant.JSON_REQUEST + "IngredientsDetails/PutIngDet.json");
        ingredientsDetails.putIngredientDetail(arg0, arg1, jsonRequest);
    }

    @When("Send put ingredien details")
    public void sendPutIngredienDetails() {
        SerenityRest.when().put(IngredientsDetails.PUT_INGREDIENT_DETAIL);
    }

    @And("Validate json schema put ingredient detail")
    public void validateJsonSchemaPutIngredientDetail() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "IngredientsDetails/PutIngDet.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Then("Status code put should be {int}")
    public void statusCodePutShouldBe(int arg0) {
        SerenityRest.then().statusCode(arg0);
    }

    @Given("Put ingredient details with invalid json body recipe {int} detail {int}")
    public void putIngredientDetailsWithInvalidJsonBodyRecipeDetail(int arg0, int arg1) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"IngredientsDetails/InvalidPutIngDet.json");
        ingredientsDetails.putIngredientDetail(arg0,arg1,jsonRequest);
    }
}
