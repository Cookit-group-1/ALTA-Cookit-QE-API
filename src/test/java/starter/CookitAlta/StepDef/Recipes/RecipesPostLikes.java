package starter.CookitAlta.StepDef.Recipes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Recipes.RecipesPostLikesAPI;

public class RecipesPostLikes {
    @Steps
    RecipesPostLikesAPI recipesPostLikesAPI;

    @Given("post Recipes Create Like user's recipe user {int}")
    public void postRecipesCreateLikeUserSRecipeUser(int id) {
        recipesPostLikesAPI.setRecipesPostLikes(id);
    }

    @When("Send request post Like user's recipe")
    public void sendRequestPostLikeUserSRecipe() {
        SerenityRest.when().get(RecipesPostLikesAPI.RECIPES_POST_LIKES);
    }

    @Given("post Recipes Create Like user's recipe user {string}")
    public void postRecipesCreateLikeUserSRecipeUser(String id) {
        recipesPostLikesAPI.setRecipesPostLikesInvalid(id);
    }
}
