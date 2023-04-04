package starter.CookitAlta.StepDef.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Comments.CommentsGetAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class CommentsGetRecipes {

    @Steps
    CommentsGetAPI commentsGetAPI;

//   GET COMMENTS RECIPES

    @Given("Comments recipes with valid data id {int}")
    public void CommentsRecipesWithValidDataId(int id) {
        File jsonRequest = new File(Constant.JSON_REQUEST + "Comments/CommentsGetRecipes.json");
        commentsGetAPI.setGetCommentsRecipes(id, jsonRequest);
    }

    @When("Send request get comments recipes")
    public void sendRequestGetCommentsRecipes() {
        SerenityRest.when().get(CommentsGetAPI.GET_COMMENTS_RECIPES);
    }
    @Then("Status code get should be {int} OK")
    public void statusCodeGetShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Validate json schema comments recipes")
    public void validateJsonSchemaCommentsRecipes() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Comments/CommentsGetRecipesValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
//    NEGATIVE STEP
    @Given("Get comment without parameter id")
    public void getCommentWithoutParameterId() {
        commentsGetAPI.setCommentsRecipesWithoutId();
    }

    @When("Send request get comment recipes without parameter id")
    public void sendRequestGetCommentRecipesWithoutParameterId() {
        SerenityRest.when().get(CommentsGetAPI.GET_COMMENTS_RECIPES_WITHOUT_ID);
    }

    @Then("Status code get should be {int} Not found")
    public void statusCodeGetShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

}