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

    @Given("Put update recipes comment")
    public void putUpdateRecipesComment() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "CommentsPutRecipes.json");
        commentsPutAPI.setPutCommentsRecipes(jsonRequest);
    }

    @When("Send request put recipes comment")
    public void sendRequestPutRecipesComment() {
        SerenityRest.when().put(CommentsPutAPI.PUT_COMMENTS_RECIPES);
    }
//    NEGATIVE STEP
    @Given("Put update without id recipes and comment")
    public void putUpdateWithoutIdRecipesAndComment() {
        commentsPutAPI.setPutWithoutIdCommentsRecipes();

    }

    @When("Send request put update recipes comment")
    public void sendRequestPutUpdateRecipesComment() {
        SerenityRest.when().put(CommentsPutAPI.PUT_WITHOUT_ID_COMMENTS_RECIPES);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(BadRequest);
    }
//    NEGATIVE STEP
    @Given("Put update with invalid parameter")
    public void putUpdateWithInvalidParameter() {
        commentsPutAPI.setPutInvalidParameter();

    }
    @When("Send request put update recipes comment invalid parameter")
    public void sendRequestPutUpdateRecipesCommentInvalidParameter() {
        SerenityRest.when().put(CommentsPutAPI.PUT_INVALID_PARAMETER);
    }
}
