package starter.CookitAlta.StepDef.Recipes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Recipes.RecipesGetDetailsAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class RecipesGetDetails {
    @Steps
    RecipesGetDetailsAPI recipesGetDetailsAPI;

    @Given("Get Recipes Details with user id {int}")
    public void getRecipesDetailsWithUserId(int id) {
        recipesGetDetailsAPI.setRecipesGetDetails(id);
    }

    @When("Send request get recipes details")
    public void sendRequestGetRecipesDetails() {
        SerenityRest.when().get(recipesGetDetailsAPI.RECIPES_GET_DETAILS);
    }

    @And("Validate get recipes details json schema")
    public void validateGetRecipesDetailsJsonSchema() {
        File JsonSchema = new File(Constant.JSON_SCHEMA+"Recipes/RecipesGetDetailsValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonSchema));
    }

    @Given("Get Recipes Details unregistered user {int}")
    public void getRecipesDetailsUnregisteredUser(int id) {
        recipesGetDetailsAPI.setRecipesGetDetails(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

    @Given("Get Recipes Details user with invalid path {string}")
    public void getRecipesDetailsUserWithInvalidPath(String id) {
        recipesGetDetailsAPI.setRecipesGetDetailsInvalid(id);
    }
}
