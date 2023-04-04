package starter.CookitAlta.CookitAPI.Images;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class Image {

    //Method POST
    public static String POST_IMAGE = Constant.BASE_URL+"recipes/{recipe_id}/images";

    @Step("Post image valid")
    public static void postImage(int recipe_id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post image invalid ")
    public static void postImageInvalid(String recipe_id, File jsonRequest){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .contentType(ContentType.JSON)
                .body(jsonRequest);
    }

    // Method PUT
    public static String PUT_IMAGES  = Constant.BASE_URL+"recipes/{recipe_id}/images/{image_id}";
    @Step("Put image valid")
    public static void putImage(int recipe_id, int image_id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("image_id", image_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put image invalid ")
    public static void putImageInvalid(String recipe_id, String image_id, File jsonRequest){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("image_id", image_id)
                .contentType(ContentType.JSON)
                .body(jsonRequest);
    }

    //Method DELETE
    public static String DELETE_IMAGES = Constant.BASE_URL+"recipes/{recipe_id}/images/{image_id}";
    @Step("Delete ingredients valid ")
    public static void deleteImageValid(int recipe_id, int image_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("image_id", image_id);
    }
    @Step("Delete image invalid")
    public static void deleteImageInvalid(String recipe_id, String image_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("image_id", image_id);
    }
}
