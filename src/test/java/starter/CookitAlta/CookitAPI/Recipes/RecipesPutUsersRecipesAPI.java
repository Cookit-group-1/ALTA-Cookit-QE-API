package starter.CookitAlta.CookitAPI.Recipes;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class RecipesPutUsersRecipesAPI
{
    public static String RECIPES_PUT_USERS_RECIPES = Constant.BASE_URL + "recipes/{id}";

    @Step("Recipes Put Users Recipes")
    public void setRecipesPutUsersRecipes(int id, File json){
        SerenityRest.given().headers("Authorization","Bearer "+Constant.BEARER_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON).body(json);
    }

}
