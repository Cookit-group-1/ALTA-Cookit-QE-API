package starter.CookitAlta.StepDef.Ingredients;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Ingredients.Ingredients;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class PostingIngredients {

    @Steps
    Ingredients ingredients;

    // Post ingredients with valid id recipe
    @Given("Post ingredients with valid id recipe {int}")
    public void postIngredientsWithValidIdRecipe(int recipe_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Ingredients/PostIngredientsValid.json");
        Ingredients.postIngredients(recipe_id, jsonRequest);
    }

    @When("Send post ingredients")
    public void sendPostIngredients() {
        SerenityRest.when().post(Ingredients.POST_INGREDIENTS);
    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Validate json schema post ingredients")
    public void validateJsonSchemaPostIngredients() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Ingredients/PostIngredients.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    // Post ingredients with invalid id recipe abc
    @Given("Post ingredients with invalid id recipe {string}")
    public void postIngredientsWithInvalidIdRecipeAbc(String recipe_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Ingredients/PostIngredientsValid.json");
        Ingredients.postIngredientsInvalid(recipe_id,jsonRequest);
    }

    @Then("Status code should be {int} Internal Server Error")
    public void statusCodeShouldBeInternalServerError(int internalServerError) {
        SerenityRest.then().statusCode(internalServerError);
    }

    @And("Validate json schema invalid ingredients")
    public void validateJsonSchemaInvalidIngredients() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Ingredients/InvalidIngredients.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Post ingredient with valid id recipe and empty json
    @Given("Post ingredient with valid id recipe {int} and empty json")
    public void postIngredientWithValidIdRecipeAndEmptyJson(int recipe_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Ingredients/PostIngredientsEmpty.json");
        Ingredients.postIngredients(recipe_id,jsonRequest);
    }

}
