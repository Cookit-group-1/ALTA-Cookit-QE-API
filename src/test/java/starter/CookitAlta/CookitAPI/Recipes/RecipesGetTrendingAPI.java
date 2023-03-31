package starter.CookitAlta.CookitAPI.Recipes;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

public class RecipesGetTrendingAPI
{
    public static String RECIPES_GET_TRENDING = Constant.BASE_URL + "recipes/trending/{id}";
    public static String RECIPES_GET_TRENDING_WITHOUT_PARAMETER = Constant.BASE_URL + "recipes/trending";

    @Step("Recipes Get Trending")
    public void setRecipesGetTrending(int id){
        SerenityRest.given().headers("Authorization","Bearer "+Constant.BEARER_TOKEN)
                .pathParam("id",id);
    }

    @Step("Recipes Get Trending without parameter")
    public void setRecipesGetTrendingWithoutParameter(){
        SerenityRest.given().headers("Authorization","Bearer "+Constant.BEARER_TOKEN);
    }
}
