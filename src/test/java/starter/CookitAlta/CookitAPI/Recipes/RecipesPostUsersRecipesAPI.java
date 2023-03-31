package starter.CookitAlta.CookitAPI.Recipes;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class RecipesPostUsersRecipesAPI
{
    public static String RECIPES_POST_USERS_RECIPES = Constant.BASE_URL + "recipes";

    @Step("Recipes Post Users Recipes")
    public void setRecipesPostUsersRecipes(File json){
        SerenityRest.given().headers("Authorization","Bearer "+Constant.BEARER_TOKEN)
                .contentType(ContentType.JSON).body(json);
    }

}
