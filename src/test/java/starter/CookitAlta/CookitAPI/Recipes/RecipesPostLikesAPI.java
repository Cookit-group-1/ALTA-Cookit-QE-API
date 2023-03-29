package starter.CookitAlta.CookitAPI.Recipes;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

public class RecipesPostLikesAPI
{
    public static String RECIPES_POST_LIKES = Constant.BASE_URL + "/recipes/{id}/like";

    @Step("Recipes Post Likes")
    public void setRecipesPostLikes(int id){
        SerenityRest.given().headers("Authorization","Bearer "+Constant.BEARER_TOKEN)
                .pathParam("id",id);
    }

    @Step("Recipes Post Likes Invalid")
    public void setRecipesPostLikesInvalid(String id){
        SerenityRest.given().headers("Authorization","Bearer "+Constant.BEARER_TOKEN)
                .pathParam("id",id);
    }
}
