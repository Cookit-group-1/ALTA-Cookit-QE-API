package starter.CookitAlta.StepDef.Recipes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Recipes.RecipesDeleteRecipesAPI;

public class RecipesDeleteRecipes {
    @Steps
    RecipesDeleteRecipesAPI recipesDeleteRecipesAPI;

    @Given("Delete user's recipe valid id {int}")
    public void deleteUserSRecipeValidId(int id) {
        recipesDeleteRecipesAPI.setRecipesDeleteRecipes(id);
    }

    @When("Send request delete user's recipe")
    public void sendRequestDeleteUserSRecipe() {
        SerenityRest.when().delete(RecipesDeleteRecipesAPI.RECIPES_DELETE_RECIPES);
    }

    @Given("Delete user's recipe valid id {string}")
    public void deleteUserSRecipeValidId(String id) {
        recipesDeleteRecipesAPI.setRecipesDeleteRecipesInvalid(id);
    }
}
