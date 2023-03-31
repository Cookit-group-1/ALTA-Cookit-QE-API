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

//   GET COMMENTS RECIPES STEPS 1

    @Given("Comments recipes with valid data id {int}")
    public void CommentsRecipesWithValidDataId(int id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Comments/CommentsGetRecipes.json");
        commentsGetAPI.setGetCommentsRecipes(id,jsonRequest);
    }

    @When("Send request get comments recipes")
    public void sendRequestGetCommentsRecipes() {
        SerenityRest.when().get(CommentsGetAPI.GET_COMMENTS_RECIPES);
    }

    @And("Validate json schema comments recipes")
    public void validateJsonSchemaCommentsRecipes() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "CommentsGetRecipesValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));


    }

    //   NEGATIVE STEPS 1
    @Given("Get list recipes without parameter id")
    public void getListRecipesWithoutParameterId() {
        commentsGetAPI.setGetCommentsRecipesWithoutId();

    }

    @When("Send request get comments recipes without parameter")
    public void sendRequestGetCommentsRecipesWithoutParameter() {
        SerenityRest.when().get(CommentsGetAPI.GET_COMMENTS_WITHOUT_ID);
    }

    @Then("Status code should be {int} internal server error")
    public void statusCodeShouldBeInternalServerError(int InternalServerError) {
        SerenityRest.then().statusCode(InternalServerError);
    }

    //    NEGATIVE STEPS 2
    @Given("Get list recipes without field comment")
    public void getListRecipesWithoutFieldComment() {
        File jsonRequest = new File(Constant.JSON_REQUEST+"CommentsGetRecipesWithoutFieldComments.json");
        commentsGetAPI.setGetCommentsWithoutComments(jsonRequest);
    }

    @When("Send request get comments recipes without field comment")
    public void sendRequestGetCommentsRecipesWithoutFieldComment() {
        SerenityRest.when().get(CommentsGetAPI.GET_COMMENTS_WITHOUT_COMMENTS);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }
}
