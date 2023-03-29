package starter.CookitAlta.StepDef.Recipes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Recipes.RecipesGetRecipesAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class RecipesGetRecipes {
    @Steps
    RecipesGetRecipesAPI recipesGetRecipesAPI;

    @Given("Get recipes without parameter")
    public void getRecipesWithoutParameter() {
        recipesGetRecipesAPI.setRecipesGetRecipesWithoutParameter();
    }

    @When("Send request get recipes without parameter")
    public void sendRequestGetRecipeswithoutparameter() {
        SerenityRest.when().get(recipesGetRecipesAPI.RECIPES_GET_RECIPES_WITHOUT_PARAMETER);
    }

    @When("Send request get recipes")
    public void sendRequestGetRecipes() {
        SerenityRest.when().get(recipesGetRecipesAPI.RECIPES_GET_RECIPES);
    }

    @And("Validate get recipes json schema")
    public void validateGetRecipesJsonSchema() {
        File JsonSchema = new File(Constant.JSON_SCHEMA+"Recipes/RecipesGetRecipesValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
    }

    @Given("Get recipes with parameter {int}")
    public void getRecipesWithParameterId(int id) {
        recipesGetRecipesAPI.setRecipesGetRecipes(id);
    }

    @Given("Get recipes with invalid parameter {string}")
    public void getRecipesWithInvalidParameter(String id) {
        recipesGetRecipesAPI.setRecipesGetRecipesInvalid(id);
    }

    @Given("Get recipes with invalid parameter more than page {int}")
    public void getRecipesWithInvalidParameterMoreThanPage(int id) {
        recipesGetRecipesAPI.setRecipesGetRecipes(id);
    }


}
