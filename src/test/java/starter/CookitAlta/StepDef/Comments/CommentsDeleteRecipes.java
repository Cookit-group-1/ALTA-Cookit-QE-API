package starter.CookitAlta.StepDef.Comments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Comments.CommentsDeleteAPI;

public class CommentsDeleteRecipes {

    @Steps
    CommentsDeleteAPI commentsDeleteAPI;

//    DELETE POSITIVE
    @Given("Delete recipes id {int} comment id {int}")
    public void deleteRecipesComment(int recipes_id, int comments_id) {
        commentsDeleteAPI.setDeleteComments(recipes_id,comments_id);
    }

    @When("Send request delete comments recipes")
    public void sendRequestDeleteCommentsRecipes() {
        SerenityRest.when().delete(CommentsDeleteAPI.DELETE_COMMENTS_RECIPES);
    }
//    NEGATIVE
    @Given("Delete recipes id {int} invalid comments id {int}")
    public void deleteRecipesIdInvalidCommentsId(int recipes_id, int comments_id) {
        commentsDeleteAPI.setDeleteComments(recipes_id,comments_id);
    }

    @Given("Delete invalid recipes id {int} comments id {int}")
    public void deleteInvalidRecipesIdCommentsId(int recipes_id, int comments_id) {
        commentsDeleteAPI.setDeleteComments(recipes_id,comments_id);
    }
}
