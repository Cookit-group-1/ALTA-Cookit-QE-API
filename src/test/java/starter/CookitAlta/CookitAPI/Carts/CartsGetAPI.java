package starter.CookitAlta.CookitAPI.Carts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class CartsGetAPI {
    public static String GET_CARTS_USERS = Constant.BASE_URL+"users/carts?page=1&limit=2";



    @Step("Carts users")
    public void setCartsUsers(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
