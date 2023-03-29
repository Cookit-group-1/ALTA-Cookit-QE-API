package starter.CookitAlta.StepDef.Recipes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Recipes.RecipesGetTimelineAPI;

public class RecipesGetTimeline {
    @Steps
    RecipesGetTimelineAPI recipesGetTimelineAPI;

    @Given("Get recipes timeline with valid parameter {int}")
    public void getRecipesTimelineWithValidParameter(int id) {
        recipesGetTimelineAPI.setRecipesGetTimeline(id);
    }

    @When("Send request get recipes timeline")
    public void sendRequestGetRecipesTimeline() {
        SerenityRest.when().get(recipesGetTimelineAPI.RECIPES_GET_TIMELINE);
    }

    @When("Send request get recipes timeline without parameter")
    public void sendRequestGetRecipesTimelineWithoutParameter() {
        SerenityRest.when().get(recipesGetTimelineAPI.RECIPES_GET_TIMELINE_WITHOUT_PARAMETER);
    }
    @And("Validate get recipes timeline json schema")
    public void validateGetRecipesTimelineJsonSchema() {
    }

    @Given("Get recipes timeline without parameter")
    public void getRecipesTimelineWithoutParameter() {
        recipesGetTimelineAPI.setRecipesGetTimelineWithoutParameter();
    }

    @Given("Get recipes with invalid parameter more than page {int}")
    public void getRecipesWithInvalidParameterMoreThanPage(int id) {
        recipesGetTimelineAPI.setRecipesGetTimeline(id);
    }

    @Given("Get recipes timeline with invalid parameter {string}")
    public void getRecipesTimelineWithInvalidParameter(String id) {
        recipesGetTimelineAPI.setRecipesGetTimelineInvalid(id);
    }

}
