package starter.CookitAlta.CookitAPI.Recipes;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

public class RecipesGetTimelineAPI
{
    public static String RECIPES_GET_TIMELINE = Constant.BASE_URL + "users/recipes/timeline/{id}";
    public static String RECIPES_GET_TIMELINE_WITHOUT_PARAMETER = Constant.BASE_URL + "users/recipes/timeline";

    @Step("Recipes Get Timeline")
    public void setRecipesGetTimeline(int id){
        SerenityRest.given().headers("Authorization","Bearer "+Constant.BEARER_TOKEN)
                .pathParam("id",id);
    }

    @Step("Recipes Get Timeline Invalid")
    public void setRecipesGetTimelineInvalid(String id){
        SerenityRest.given().headers("Authorization","Bearer "+Constant.BEARER_TOKEN)
                .pathParam("id",id);
    }
    @Step("Recipes Get Timeline without parameter")
    public void setRecipesGetTimelineWithoutParameter(){
        SerenityRest.given().headers("Authorization","Bearer "+Constant.BEARER_TOKEN);
    }
}
