package starter.CookitAlta.StepDef.Recipes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Recipes.RecipesPostUsersRecipesAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class RecipesPostUsersRecipes {
    @Steps
    RecipesPostUsersRecipesAPI recipesPostUsersRecipesAPI;

    @Given("post Recipes Insert new user's recipe valid json")
    public void postRecipesInsertNewUserSRecipeValidJson() {
        File JsonReq = new File(Constant.JSON_REQUEST + "Recipes/RecipesPostUserRecipes.json");
       recipesPostUsersRecipesAPI.setRecipesPostUsersRecipes(JsonReq);
    }

    @When("Send request post new user's recipe")
    public void sendRequestPostNewUserSRecipe() {
        SerenityRest.when().post(recipesPostUsersRecipesAPI.RECIPES_POST_USERS_RECIPES);
    }

    @And("Validate pos recipes json schema")
    public void validatePosRecipesJsonSchema() {
        File Json = new File(Constant.JSON_SCHEMA+"Recipes/RecipesPostUsersRecipesValidation.json");
        recipesPostUsersRecipesAPI.setRecipesPostUsersRecipes(Json);
    }

    @Given("post Recipes Insert new user's recipe without name json")
    public void postRecipesInsertNewUserSRecipeWithoutNameJson() {
        File Json = new File(Constant.JSON_REQUEST+"Recipes/RecipesPostUserRecipesWithoutName.json");
        recipesPostUsersRecipesAPI.setRecipesPostUsersRecipes(Json);
    }

    @Given("post Recipes Insert new user's recipe without description json")
    public void postRecipesInsertNewUserSRecipeWithoutDescriptionJson() {
        File Json = new File(Constant.JSON_REQUEST+"Recipes/RecipesPostUserRecipesWithoutDescription.json");
        recipesPostUsersRecipesAPI.setRecipesPostUsersRecipes(Json);
    }

    @Given("post Recipes Insert new user's recipe without Fill Field name json")
    public void postRecipesInsertNewUserSRecipeWithoutFillFieldNameJson() {
        File Json = new File(Constant.JSON_REQUEST+"Recipes/RecipesPostUserRecipesWithoutFillFieldName.json");
        recipesPostUsersRecipesAPI.setRecipesPostUsersRecipes(Json);
    }

    @Given("post Recipes Insert new user's recipe without Fill Field description json")
    public void postRecipesInsertNewUserSRecipeWithoutFillFieldDescriptionJson() {
        File Json = new File(Constant.JSON_REQUEST+"Recipes/RecipesPostUserRecipesWithoutFillFieldDescription.json");
        recipesPostUsersRecipesAPI.setRecipesPostUsersRecipes(Json);
    }

    @Given("post Recipes Insert new user's recipe without all Fill Field json")
    public void postRecipesInsertNewUserSRecipeWithoutAllFillFieldJson() {
        File Json = new File(Constant.JSON_REQUEST+"Recipes/RecipesPostUserRecipesWithoutAllField.json");
        recipesPostUsersRecipesAPI.setRecipesPostUsersRecipes(Json);
    }

}
