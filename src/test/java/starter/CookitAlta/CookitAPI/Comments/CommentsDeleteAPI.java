package starter.CookitAlta.CookitAPI.Comments;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

public class CommentsDeleteAPI {

    public static String DELETE_COMMENTS_RECIPES = Constant.BASE_URL+"recipes/{recipes_id}/comments/{comments_id}";




    @Step("Delete comments recipes")
    public void setDeleteComments(int recipes_id, int comments_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipes_id",recipes_id)
                .pathParam("comments_id",comments_id);
    }

}
