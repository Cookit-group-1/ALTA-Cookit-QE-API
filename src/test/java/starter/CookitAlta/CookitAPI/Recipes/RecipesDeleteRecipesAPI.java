package starter.CookitAlta.CookitAPI.Recipes;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

public class RecipesDeleteRecipesAPI
{
    public static String RECIPES_DELETE_RECIPES = Constant.BASE_URL + "recipes/{id}";


    @Step("RecipesDeleteRecipes")
    public void setRecipesDeleteRecipes(int id){
        SerenityRest.given().headers("Authorization","Bearer"+Constant.BEARER_TOKEN)
                .pathParam("id",id);
    }

    @Step("RecipesDeleteLikeRecipes")
    public void setRecipesDeleteRecipesInvalid(String id){
        SerenityRest.given().headers("Authorization","Bearer"+Constant.BEARER_TOKEN)
                .pathParam("id",id);
    }

}
