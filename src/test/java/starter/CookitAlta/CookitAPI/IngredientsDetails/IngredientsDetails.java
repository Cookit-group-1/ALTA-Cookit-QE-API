package starter.CookitAlta.CookitAPI.IngredientsDetails;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class IngredientsDetails {
    public static String POST_INGREDIENT_DETAIL = Constant.BASE_URL+"recipes/{recipe_id}/ingredients/{ingredient_id}/ingredientDetails";
    public static String PUT_INGREDIENT_DETAIL = Constant.BASE_URL+"recipes/{recipe_id}/ingredients/ingredientDetails/{ingredient_detail_id}";
    public static String DELETE_INGREDIENT_DETAIL = Constant.BASE_URL+"recipes/{recipe_id}/ingredients/ingredientDetails/{ingredient_detail_id}";
    @Step("Post ingredients details")
    public void postIngredientDetail(int recipe_id, int ingredient_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_id", ingredient_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put ingredients details")
    public void putIngredientDetail(int recipe_id, int ingredient_detail_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_detail_id", ingredient_detail_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete ingredients details")
    public void deleteIngredientDetail(int recipe_id, int ingredient_detail_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("ingredient_detail_id", ingredient_detail_id);
    }

}
