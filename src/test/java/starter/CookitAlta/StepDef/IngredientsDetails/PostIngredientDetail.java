package starter.CookitAlta.StepDef.IngredientsDetails;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.IngredientsDetails.IngredientsDetails;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class PostIngredientDetail {
    @Steps
    IngredientsDetails ingredientsDetails;

    @Given("Post ingredient details with valid id recipe {int} ingredient {int}")
    public void postIngredientDetailsWithValidIdRecipeIngredient(int arg0, int arg1) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"IngredientsDetails/PostIngDet.json");
        ingredientsDetails.postIngredientDetail(arg0,arg1,jsonRequest);
    }

    @When("Send post ingredien details")
    public void sendPostIngredienDetails() {
        SerenityRest.when().post(IngredientsDetails.POST_INGREDIENT_DETAIL);
    }

    @And("Validate json schema post ingredient detail")
    public void validateJsonSchemaPostIngredientDetail() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"IngredientsDetails/PostIngDet.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }

    @And("Validate json schema invalid ingredient detail")
    public void validateJsonSchemaInvalidIngredientDetail() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"IngredientsDetails/InvalidIngDet.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post ingredient details with valid id recipe {int} ingredient {int} and empty json")
    public void postIngredientDetailsWithValidIdRecipeIngredientAndEmptyJson(int arg0, int arg1) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"IngredientsDetails/InvalidPutIngDet.json");
        ingredientsDetails.putIngredientDetail(arg0,arg1,jsonRequest);
    }
}
