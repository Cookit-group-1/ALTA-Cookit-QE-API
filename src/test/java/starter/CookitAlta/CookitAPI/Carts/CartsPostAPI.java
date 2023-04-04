package starter.CookitAlta.CookitAPI.Carts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class CartsPostAPI {

    public static String POST_INSERT_NEW_CARTS = Constant.BASE_URL+"users/carts";


    @Step("Post insert new users carts")
    public void setInsertMewUsersCarts(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

}
