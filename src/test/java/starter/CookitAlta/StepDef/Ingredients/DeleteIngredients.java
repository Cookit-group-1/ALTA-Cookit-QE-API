package starter.CookitAlta.StepDef.Ingredients;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Ingredients.Ingredients;


public class DeleteIngredients {

    @Steps
    Ingredients ingredients;

    @Given("Delete ingredient with valid recipe id {int} and ingredient id {int}")
    public void deleteIngredientWithValidRecipeIdAndIngredientId(int recipe_id, int ingredient_id) {
        Ingredients.deleteIngredientValid(recipe_id, ingredient_id);
    }

    @When("Send request delete ingredients")
    public void sendRequestDeleteIngredients() {
        SerenityRest.when().delete(Ingredients.DELETE_INGREDIENTS);
    }

    @Given("Delete ingredient with invalid recipe id {string} and ingredient id {string}")
    public void deleteIngredientWithInvalidRecipeIdAndIngredientId(String recipe_id, String ingredient_id) {
        Ingredients.deleteIngredientInvalid(recipe_id, ingredient_id);
    }
}
