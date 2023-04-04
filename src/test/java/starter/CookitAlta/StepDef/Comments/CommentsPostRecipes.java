package starter.CookitAlta.StepDef.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Comments.CommentsPostAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class CommentsPostRecipes {
    @Steps
    CommentsPostAPI commentsPostAPI;


    //    POST COMMENT RECIPES STEP
    @Given("Insert new recipes comment id {int}")
    public void insertNewRecipesCommentId(int id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Comments/CommentsPostRecipes.json");
        commentsPostAPI.setPostCommentsRecipesId(id,jsonRequest);
    }

    @When("Send request update recipes comment")
    public void sendRequestUpdateRecipesComment() {
        SerenityRest.when().post(CommentsPostAPI.POST_COMMENTS_RECIPES);

    }

    @And("Validate json schema comments post recipes")
    public void validateJsonSchemaCommentsPostRecipes() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Comments/CommentsPostRecipesValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }
//    NEGATIVE
    @Given("Insert without fill field comment id {int}")
    public void insertWithoutFillFieldCommentId(int id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Comments/CommentsPostRecipesWithoutFieldComment.json");
        commentsPostAPI.setPostCommentsRecipesId(id,jsonRequest);
    }

    @When("Send request post insert new recipes comment without field comment")
    public void sendRequestPostInsertNewRecipesCommentWithoutFieldComment() {
        SerenityRest.when().post(CommentsPostAPI.POST_COMMENTS_RECIPES);

    }
}
