package starter.DummyJSON.CookitAPI;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.DummyJSON.Utils.Constant;

import java.io.File;

public class AuthAPI {
    public static String POST_LOGIN = Constant.BASE_URL +"auth/login";

    @Step ("Post login with valid JSON")
    public void postLogin(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}
