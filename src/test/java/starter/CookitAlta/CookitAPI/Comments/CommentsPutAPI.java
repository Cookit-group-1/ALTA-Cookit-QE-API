package starter.CookitAlta.CookitAPI.Comments;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class CommentsPutAPI {

    public static String PUT_COMMENTS_RECIPES = Constant.BASE_URL+"/recipes/{id}/comments/id}";
    public static String PUT_WITHOUT_ID_COMMENTS_RECIPES = Constant.BASE_URL+"/recipes/{}/comments/{}";
    public static String PUT_INVALID_PARAMETER = Constant.BASE_URL+"/recipes/{}/{}";

    @Step("Put comments recipes")
    public void setPutCommentsRecipes(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put without id comments and recipes")
    public void setPutWithoutIdCommentsRecipes(){
        SerenityRest.given();
    }
    @Step("Put invalid parameter")
    public void setPutInvalidParameter(){
        SerenityRest.given();
    }
}
