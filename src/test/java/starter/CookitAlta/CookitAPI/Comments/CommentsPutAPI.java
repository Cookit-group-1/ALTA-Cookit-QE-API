package starter.CookitAlta.CookitAPI.Comments;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class CommentsPutAPI {

    public static String PUT_COMMENTS_RECIPES = Constant.BASE_URL+"recipes/{recipe_id}/comments/{comments_id}";

    @Step("Put comments recipes")
    public void setPutCommentsRecipes(int recipe_id,int comments_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id",recipe_id)
                .pathParam("comments_id",comments_id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
