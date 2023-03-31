package starter.CookitAlta.CookitAPI.Carts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class CartsPutAPI {

    public static String PUT_UPDATE_CARTS = Constant.BASE_URL+"users/carts/{cart_id}";


    @Step("Put update carts users")
    public void setUpdateCartsUsers(int id ,File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("cart_id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

}
