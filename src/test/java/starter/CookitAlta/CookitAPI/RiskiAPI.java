package starter.CookitAlta.CookitAPI;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;
import java.io.File;


public class RiskiAPI {

    // STEPS
    public static String POST_STEP = Constant.BASE_URL+"recipes/{recipeId}/steps";

    @Step("Post insert new recipe step")
    public void postStep(int recipeId, File json){
        SerenityRest.given()
                .pathParam("receipId",recipeId)
                .contentType(ContentType.JSON)
                .body(json);
    }

}
