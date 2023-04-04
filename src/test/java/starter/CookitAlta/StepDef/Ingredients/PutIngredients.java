package starter.CookitAlta.StepDef.Ingredients;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Ingredients.Ingredients;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class PutIngredients {

    @Steps
    Ingredients ingredients;

    //Put ingredients with valid id and json file
    @Given("Put ingredients with valid id recipe {int} and ingredient id {int}")
    public void putIngredientsWithValidIdRecipeAndIngredientId(int recipe_id, int ingredient_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Ingredients/PutIngredientsValid.json");
        Ingredients.putIngredient(recipe_id, ingredient_id, jsonRequest);
    }

    @When("Send put ingredients")
    public void sendPutIngredients() {
        SerenityRest.when().put(Ingredients.PUT_INGREDIENTS);
    }

    @And("Validate json schema put ingredients")
    public void validateJsonSchemaPutIngredients() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Ingredients/PutIngredients.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Put ingredients with invalid id and valid json file
    @Given("Put ingredients with invalid id recipe {string} and id ingredient {string}")
    public void putIngredientsWithInvalidIdRecipeAndIdIngredient(String recipe_id, String ingredient_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Ingredients/PutIngredientsValid.json");
        Ingredients.putIngredientsInvalid(recipe_id, ingredient_id, jsonRequest);
    }

    @And("Validate json schema invalid put ingredients")
    public void validateJsonSchemaInvalidPutIngredients() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Ingredients/PutIngredients.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Put ingredients with valid id recipe and invalid id ingredient and valid json file
    @Given("Put ingredients with valid id recipe {int} and ingredient id {string}")
    public void putIngredientsWithValidIdRecipeAndIngredientId(int recipe_id, String ingredient_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Ingredients/PutIngredientsValid.json");
        Ingredients.putIngredientsInvalidIngredientId(recipe_id, ingredient_id, jsonRequest);
    }

    //Put ingredients with valid id and empty json
    @Given("Put ingredients with valid id recipe {int} and ingredient id {int} and empty json")
    public void putIngredientsWithValidIdRecipeAndIngredientIdAndEmptyJson(int recipe_id, int ingredient_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Ingredients/PutIngredientsEmpty.json");
        Ingredients.putIngredient(recipe_id, ingredient_id, jsonRequest);
    }

    //Put ingredients with invalid id and empty json
    @Given("Put ingredients with invalid id recipe {string} and id ingredient {string} and empty json")
    public void putIngredientsWithInvalidIdRecipeAndIdIngredientAndEmptyJson(String recipe_id, String ingredient_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Ingredients/PutIngredientsEmpty.json");
        Ingredients.putIngredientsInvalid(recipe_id, ingredient_id, jsonRequest);
    }

    @And("Validate json schema invalid put ingredients empty")
    public void validateJsonSchemaInvalidPutIngredientsEmpty() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Ingredients/PutIngredientsEmpty.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


}
