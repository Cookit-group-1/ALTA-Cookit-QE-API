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
    @Given("Delete recipes comment")
    public void deleteRecipesComment() {
        commentsDeleteAPI.setDeleteComments();
    }

    @When("Send request delete comments recipes")
    public void sendRequestDeleteCommentsRecipes() {
        SerenityRest.when().delete(CommentsDeleteAPI.DELETE_COMMENTS_RECIPES);
    }
//    DELETE NEGATIVE
    @Given("delete recipes comment with invalid parameter id")
    public void deleteRecipesCommentWithInvalidParameterId() {
        commentsDeleteAPI.setDeleteCommentsRecipes();
    }

    @When("Send request delete invalid id")
    public void sendRequestDeleteInvalidId() {
        SerenityRest.when().delete(CommentsDeleteAPI.DELETE_COMMENTS_RECIPES_INVALID);
    }
//    DELETE NEGATIVE
    @Given("Delete without invalid parameter")
    public void deleteWithoutInvalidParameter() {
        commentsDeleteAPI.setDeleteCommentsRecipesInvalid();
    }

    @When("Send request delete invalid parameter")
    public void sendRequestDeleteInvalidParameter() {
        SerenityRest.when().delete(CommentsDeleteAPI.DELETE_INVALID_PARAMETER);
    }
}
