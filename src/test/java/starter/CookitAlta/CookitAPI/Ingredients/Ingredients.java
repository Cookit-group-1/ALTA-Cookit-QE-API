package starter.CookitAlta.CookitAPI.Ingredients;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class Ingredients {

    //Method POST
    public static String POST_INGREDIENTS = Constant.BASE_URL+"recipes/{recipe_id}/ingredients";
    @Step("Post ingredients")
    public static void postIngredients(int recipe_id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post ingredients invalid")
    public static void postIngredientsInvalid(String recipe_id, File jsonRequest){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .contentType(ContentType.JSON)
                .body(jsonRequest);
    }

    // Method PUT
    public static String PUT_INGREDIENTS       = Constant.BASE_URL+"recipes/{recipe_id}/ingredients/{ingredient_id}";
    @Step("Put ingredients valid")
    public static void putIngredient(int recipe_id, int ingredient_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_id", ingredient_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put ingredients invalid")
    public static void putIngredientsInvalid(String recipe_id, String ingredient_id, File jsonRequest){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_id", ingredient_id)
                .contentType(ContentType.JSON)
                .body(jsonRequest);
    }

    @Step("Put ingredients invalid ingredient id")
    public static void putIngredientsInvalidIngredientId(int recipe_id, String ingredient_id, File jsonRequest){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_id", ingredient_id)
                .contentType(ContentType.JSON)
                .body(jsonRequest);
    }



    //Method DELETE
    public static String DELETE_INGREDIENTS = Constant.BASE_URL+"recipes/{recipe_id}/ingredients/{ingredient_id}";
    @Step("Delete ingredients valid ")
    public static void deleteIngredientValid(int recipe_id, int ingredient_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_id", ingredient_id);
    }
    @Step("Delete ingredients invalid")
    public static void deleteIngredientInvalid(String recipe_id, String ingredient_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_id", ingredient_id);
    }
}
