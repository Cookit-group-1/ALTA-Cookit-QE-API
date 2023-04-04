package starter.CookitAlta.CookitAPI.Comments;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class CommentsGetAPI {
    public static String GET_COMMENTS_RECIPES = Constant.BASE_URL + "recipes/{id}/comments";
    public static String GET_COMMENTS_RECIPES_WITHOUT_ID = Constant.BASE_URL + "recipes//comments";


    //    GET POSITIVE
    @Step("Comments recipes id 1")
    public void setGetCommentsRecipes(int id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);

    }
    @Step("Comments recipes without parameter id")
    public void setCommentsRecipesWithoutId(){
        SerenityRest.given();
    }
}
