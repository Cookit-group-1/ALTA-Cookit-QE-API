package starter.CookitAlta.CookitAPI.Recipes;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.Utils.Constant;

public class RecipesDeleteLikeAPI
{
    public static String RECIPES_DELETE_LIKE = Constant.BASE_URL + "recipes/{id}/unlike";


    @Step("RecipesDeleteLike")
    public void setRecipesDeleteLike(int id){
        SerenityRest.given().headers("Authorization","Bearer"+Constant.BEARER_TOKEN)
                .pathParam("id",id);
    }

    @Step("RecipesDeleteLikeInvalid")
    public void setRecipesDeleteLikeInvalid(String id){
        SerenityRest.given().headers("Authorization","Bearer"+Constant.BEARER_TOKEN)
                .pathParam("id",id);
    }

}
