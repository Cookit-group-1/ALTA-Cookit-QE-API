package starter.CookitAlta.CookitAPI.Comments;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

public class CommentsDeleteAPI {

    public static String DELETE_COMMENTS_RECIPES = Constant.BASE_URL+"recipes/{id}/comments/{id}";
    public static String DELETE_COMMENTS_RECIPES_INVALID = Constant.BASE_URL+"recipes/{1000}/comments/{1000}";
    public static String DELETE_INVALID_PARAMETER = Constant.BASE_URL+"recipes/{id}/commentsxyz/{id}";



    @Step("Delete comments recipes")
    public void setDeleteComments(){
        SerenityRest.given();
    }

    @Step("Delete comments recipes with invalid id")
    public void setDeleteCommentsRecipes(){
        SerenityRest.given();
    }
    @Step("Delete comments recipes invalid parameter")
    public void setDeleteCommentsRecipesInvalid(){
        SerenityRest.given();
    }


}
