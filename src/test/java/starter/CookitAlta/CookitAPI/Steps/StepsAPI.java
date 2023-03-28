package starter.CookitAlta.CookitAPI.Steps;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class StepsAPI {
    public static String POST_STEP = Constant.BASE_URL+"recipes/{recipe_id}/steps";

    @Step("Post new recipes")
    public void postStep (int recipe_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
