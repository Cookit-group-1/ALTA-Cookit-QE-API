package starter.CookitAlta.CookitAPI.Recipes;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

public class RecipesGetRecipesAPI
{
    public static String RECIPES_GET_RECIPES_WITHOUT_PARAMETER = Constant.BASE_URL + "recipes";

    @Step("Recipes Get Recipes without parameter")
    public void setRecipesGetRecipesWithoutParameter(){
        SerenityRest.given().headers("Authorization","Bearer "+Constant.BEARER_TOKEN);
    }
}
