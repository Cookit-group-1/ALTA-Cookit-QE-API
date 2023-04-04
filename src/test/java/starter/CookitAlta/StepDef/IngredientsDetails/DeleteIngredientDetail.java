package starter.CookitAlta.StepDef.IngredientsDetails;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.IngredientsDetails.IngredientsDetails;

public class DeleteIngredientDetail {
    @Steps
    IngredientsDetails ingredientsDetails;
    @Given("Delete ingredient details with valid recipe {int} details {int}")
    public void deleteIngredientDetailsWithValidRecipeDetails(int arg0, int arg1) {
        ingredientsDetails.deleteIngredientDetail(arg0, arg1);
    }

    @When("Send request delete ingredients detail")
    public void sendRequestDeleteIngredientsDetail() {
        SerenityRest.when().delete(IngredientsDetails.DELETE_INGREDIENT_DETAIL);
    }

    @Given("Delete ingredient details with invalid recipe {int} details {int}")
    public void deleteIngredientDetailsWithInvalidRecipeDetails(int arg0, int arg1) {
        ingredientsDetails.deleteIngredientDetail(arg0, arg1);
    }
}
