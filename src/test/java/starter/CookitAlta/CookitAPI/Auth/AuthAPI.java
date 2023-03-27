package starter.CookitAlta.CookitAPI.Auth;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;
import java.io.File;

public class AuthAPI {
    public static String POST_LOGIN = Constant.BASE_URL+"register";

    @Step("Register with valid data")
    public void postRegister(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
