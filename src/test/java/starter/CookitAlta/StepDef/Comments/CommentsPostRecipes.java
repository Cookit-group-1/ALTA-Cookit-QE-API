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


    //    POST COMMENT RECIPES STEP 2
    @Given("Insert new recipes comment")
    public void insertNewRecipesComment() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "CommentsPostRecipes.json");
        commentsPostAPI.setPostCommentsRecipes(jsonRequest);
    }

    @When("Send request update recipes comment")
    public void sendRequestUpdateRecipesComment() {
        SerenityRest.when().post(CommentsPostAPI.POST_COMMENTS_RECIPES);

    }

    @And("Validate json schema comments post recipes")
    public void validateJsonSchemaCommentsPostRecipes() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "CommentsPostRecipesValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }

    //    NEGATIVE POST
    @Given("Post insert recipes comment without parameter id")
    public void postInsertRecipesCommentWithoutParameterId() {
        commentsPostAPI.setPostCommentsWithoutId();

    }

    @When("Send request post comments recipes without parameter")
    public void sendRequestPostCommentsRecipesWithoutParameter() {
        SerenityRest.when().post(CommentsPostAPI.POST_COMMENTS_WITHOUT_ID);
    }

    //    NEGATIVE POST
    @Given("Post insert new recipes without field comment")
    public void postInsertNewRecipesWithoutFieldComment() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "CommentsGetRecipesWithoutFieldComments.json");
        commentsPostAPI.setPostRecipesWithoutComments(jsonRequest);

    }

    @When("Send request post comments recipes without field comment")
    public void sendRequestPostCommentsRecipesWithoutFieldComment() {
        SerenityRest.when().post(CommentsPostAPI.POST_COMMENTS_WITHOUT_FIELD_COMMENTS);
    }
}
