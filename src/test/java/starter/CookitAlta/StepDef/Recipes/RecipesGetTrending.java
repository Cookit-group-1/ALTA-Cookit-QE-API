package starter.CookitAlta.StepDef.Recipes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Recipes.RecipesGetTrendingAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class RecipesGetTrending {
    @Steps
    RecipesGetTrendingAPI recipesGetTrendingAPI;

    @Given("Get recipes trending with valid parameter {int}")
    public void getRecipesTrendingWithValidParameter(int id) {
        recipesGetTrendingAPI.setRecipesGetTrending(id);
    }

    @When("Send request get recipes trending")
    public void sendRequestGetRecipesTrending() {
        SerenityRest.when().get(recipesGetTrendingAPI.RECIPES_GET_TRENDING);
    }

    @And("Validate get trending json schema")
    public void validateGetTrendingJsonSchema() {
        File JsonSchema =new File(Constant.JSON_SCHEMA+"Recipes/RecipesGetTrendingValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
    }

    @Given("Get trending without parameter")
    public void getTrendingWithoutParameter() {
        recipesGetTrendingAPI.setRecipesGetTrendingWithoutParameter();
    }

    @When("Send request get recipes trending without parameter")
    public void sendRequestGetRecipesTrendingWithoutParameter() {
        SerenityRest.when().get(recipesGetTrendingAPI.RECIPES_GET_TRENDING_WITHOUT_PARAMETER);
    }
}
