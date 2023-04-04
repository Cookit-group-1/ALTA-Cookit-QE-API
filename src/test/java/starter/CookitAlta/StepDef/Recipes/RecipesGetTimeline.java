package starter.CookitAlta.StepDef.Recipes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Recipes.RecipesGetTimelineAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class RecipesGetTimeline {
    @Steps
    RecipesGetTimelineAPI recipesGetTimelineAPI;

    @Given("Get recipes timeline without parameter")
    public void getRecipesTimelineWithoutParameter() {
        recipesGetTimelineAPI.setRecipesGetTimelineWithoutParameter();
    }

    @When("Send request get recipes timeline without parameter")
    public void sendRequestGetRecipesTimelineWithoutParameter() {
        SerenityRest.when().get(recipesGetTimelineAPI.RECIPES_GET_TIMELINE_WITHOUT_PARAMETER);
    }
    @And("Validate get recipes timeline json schema")
    public void validateGetRecipesTimelineJsonSchema() {
        File JsonSchema = new File(Constant.JSON_SCHEMA+"Recipes/RecipesGetTimelineValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
    }

}
