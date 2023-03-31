package starter.CookitAlta.CookitAPI.Comments;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class CommentsPostAPI {

    public static String POST_COMMENTS_RECIPES = Constant.BASE_URL+"recipes/{id}/comments";
    public static String POST_COMMENTS_WITHOUT_ID = Constant.BASE_URL+"recipes/{id}/comments";
    public static String POST_COMMENTS_WITHOUT_FIELD_COMMENTS = Constant.BASE_URL+"recipes/{id}/comments";


    //    POST POSITIVE
    @Step("Post comments recipes")
    public void setPostCommentsRecipes(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
//    POST NEGATIVE
    @Step("Comments post recipes without id")
    public void setPostCommentsWithoutId(){
        SerenityRest.given();
    }
    @Step("Comments post recipes without fill field comments")
    public void setPostRecipesWithoutComments(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

}
