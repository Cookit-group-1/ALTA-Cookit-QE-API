package starter.CookitAlta.CookitAPI.Comments;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class CommentsPostAPI {

    public static String POST_COMMENTS_RECIPES = Constant.BASE_URL+"recipes/{id}/comments";


    //    POST
    @Step("Post comments recipes")
    public void setPostCommentsRecipesId(int id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

}
