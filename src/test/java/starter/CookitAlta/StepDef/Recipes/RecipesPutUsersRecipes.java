package starter.CookitAlta.StepDef.Recipes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Recipes.RecipesPostUsersRecipesAPI;
import starter.CookitAlta.CookitAPI.Recipes.RecipesPutUsersRecipesAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class RecipesPutUsersRecipes {
    @Steps
    RecipesPutUsersRecipesAPI recipesPutUsersRecipesAPI;

    @Given("Put Recipes Update user's recipes valid json with id {int}")
    public void putRecipesUpdateUserSRecipesValidJsonWithId(int id) {
        File JsonRequest = new File(Constant.JSON_REQUEST+"Recipes/RecipesPutUsersRecipes.json");
        recipesPutUsersRecipesAPI.setRecipesPutUsersRecipes(id,JsonRequest);
    }

    @When("Send request put update recipes")
    public void sendRequestPutUpdateRecipes() {
        SerenityRest.when().post(recipesPutUsersRecipesAPI.RECIPES_PUT_USERS_RECIPES);
    }

    @And("Validate put update recipes json schema")
    public void validatePutUpdateRecipesJsonSchema() {
        File JsonSchema = new File(Constant.JSON_SCHEMA+"Recipes/RecipesPutUsersRecipesValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
    }

    @Given("Put Recipes Update user's recipes valid json without field name json")
    public void putRecipesUpdateUserSRecipesValidJsonWithoutFieldNameJson(int id) {
        File JsonRequest = new File(Constant.JSON_REQUEST+"Recipes/RecipesPutUsersRecipesWithoutFieldName.json");
        recipesPutUsersRecipesAPI.setRecipesPutUsersRecipes(id,JsonRequest);
    }

    @Given("Put Recipes Update user's recipes valid json without field description json")
    public void putRecipesUpdateUserSRecipesValidJsonWithoutFieldDescriptionJson(int id) {
        File JsonRequest = new File(Constant.JSON_REQUEST+"Recipes/RecipesPutUsersRecipesWithoutFieldDescription.json");
        recipesPutUsersRecipesAPI.setRecipesPutUsersRecipes(id,JsonRequest);
    }

    @Given("Put Recipes Update user's recipes valid json with empty field name json")
    public void putRecipesUpdateUserSRecipesValidJsonWithEmptyFieldNameJson(int id) {
        File JsonRequest = new File(Constant.JSON_REQUEST+"Recipes/RecipesPutUsersRecipesWithoutEmptyFieldName.json");
        recipesPutUsersRecipesAPI.setRecipesPutUsersRecipes(id,JsonRequest);
    }

    @Given("Put Recipes Update user's recipes valid json with empty field description json")
    public void putRecipesUpdateUserSRecipesValidJsonWithEmptyFieldDescriptionJson(int id) {
        File JsonRequest = new File(Constant.JSON_REQUEST+"Recipes/RecipesPutUsersRecipesWithoutEmptyFieldDescription.json");
        recipesPutUsersRecipesAPI.setRecipesPutUsersRecipes(id,JsonRequest);
    }
}
