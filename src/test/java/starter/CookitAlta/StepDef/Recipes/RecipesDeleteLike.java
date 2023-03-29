package starter.CookitAlta.StepDef.Recipes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Recipes.RecipesDeleteLikeAPI;

public class RecipesDeleteLike {
    @Steps
    RecipesDeleteLikeAPI recipesDeleteLikeAPI;

    @Given("Delete user's Unlike recipe valid id {int}")
    public void deleteUserSUnlikeRecipeValidId(int id) {
        recipesDeleteLikeAPI.setRecipesDeleteLike(id);
    }

    @When("Send request delete user's Unlike")
    public void sendRequestDeleteUserSUnlike() {
        SerenityRest.when().delete(recipesDeleteLikeAPI.RECIPES_DELETE_LIKE);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    @Given("Delete user's Unlike recipe valid id {string}")
    public void deleteUserSUnlikeRecipeValidId(String id) {
        recipesDeleteLikeAPI.setRecipesDeleteLikeInvalid(id);
    }
}
