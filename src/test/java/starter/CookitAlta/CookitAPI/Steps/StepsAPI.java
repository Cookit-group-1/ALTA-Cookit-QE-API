package starter.CookitAlta.CookitAPI.Steps;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class StepsAPI {
    public static String POST_STEP = Constant.BASE_URL+"recipes/{recipe_id}/steps";
    public static String PUT_STEP = Constant.BASE_URL+"recipes/{recipe_id}/steps/{step_id}";
    public static String PUT_STEP_VALID = Constant.BASE_URL+"recipes/18/steps/29";

    @Step("Post steps")
    public void postStep (int recipe_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put steps")
    public void putStep(int recipe_id, int step_id, File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("recipe_id", recipe_id)
                .pathParam("step_id", step_id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
