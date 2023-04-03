package starter.CookitAlta.StepDef.Comments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Comments.CommentsPutAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;
public class CommentsPutRecipes {

    @Steps
    CommentsPutAPI commentsPutAPI;

    @Given("Put update recipes id {int} comment id {int}")
    public void putUpdateRecipesCommentId(int recipes_id, int comments_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST + "Comments/CommentsPutRecipes.json");
        commentsPutAPI.setPutCommentsRecipes(recipes_id, comments_id, jsonRequest);
    }

    @When("Send request put recipes comment")
    public void sendRequestPutRecipesComment() {
        SerenityRest.when().put(CommentsPutAPI.PUT_COMMENTS_RECIPES);
    }
    @Then("Status code put should be {int} OK")
    public void statusCodePutShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @Given("Put update invalid recipes id {int} comment id {int}")
    public void putUpdateRecipesCommentInvalid(int recipes_id, int comments_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST + "Comments/CommentsPutRecipesInvalid.json");
        commentsPutAPI.setPutCommentsRecipes(recipes_id, comments_id, jsonRequest);
    }

    @Given("Put update without body json recipes id {int} comment id {int}")
    public void putUpdateWithoutBodyJsonRecipesIdCommentId(int recipes_id, int comments_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST + "Comments/CommentsPutRecipesWithoutBody.json");
        commentsPutAPI.setPutCommentsRecipes(recipes_id, comments_id, jsonRequest);
    }

}