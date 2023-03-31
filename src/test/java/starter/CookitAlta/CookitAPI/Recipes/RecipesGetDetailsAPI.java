package starter.CookitAlta.CookitAPI.Recipes;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

public class RecipesGetDetailsAPI
{
    public static String RECIPES_GET_DETAILS = Constant.BASE_URL + "recipes/{id}/detail";

    @Step("Recipes Get Details")
    public void setRecipesGetDetails(int id){
        SerenityRest.given().headers("Authorization","Bearer"+Constant.BEARER_TOKEN)
                .pathParam("id",id);

    }
    @Step("Recipes Get Details Invalid")
    public void setRecipesGetDetailsInvalid(String id){
        SerenityRest.given().headers("Authorization","Bearer"+Constant.BEARER_TOKEN)
                .pathParam("id",id);

    }


}
