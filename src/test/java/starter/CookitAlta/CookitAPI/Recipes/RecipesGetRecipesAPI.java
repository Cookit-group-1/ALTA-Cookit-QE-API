package starter.CookitAlta.CookitAPI.Recipes;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

public class RecipesGetRecipesAPI
{
    public static String RECIPES_GET_RECIPES = Constant.BASE_URL + "recipes/{id}";
    public static String RECIPES_GET_RECIPES_WITHOUT_PARAMETER = Constant.BASE_URL + "recipes";

    @Step("Recipes Get Recipes")
    public void setRecipesGetRecipes(int id){
        SerenityRest.given().headers("Authorization","Bearer "+Constant.BEARER_TOKEN)
                .pathParam("id",id);
    }

    @Step("Recipes Get Recipes Invalid")
    public void setRecipesGetRecipesInvalid(String id){
        SerenityRest.given().headers("Authorization","Bearer "+Constant.BEARER_TOKEN)
                .pathParam("id",id);
    }
    @Step("Recipes Get Recipes without parameter")
    public void setRecipesGetRecipesWithoutParameter(){
        SerenityRest.given().headers("Authorization","Bearer "+Constant.BEARER_TOKEN);
    }
}
