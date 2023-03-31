package starter.CookitAlta.CookitAPI.Carts;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

public class CartsDeleteAPI {

    public static String DELETE_CARTS_USERS = Constant.BASE_URL+"users/carts/{cart_id}";


    @Step("Delete carts Users")
    public void setDeleteCartsUsers(int id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("cart_id",id);

    }
    @Step("Delete cart users invalid id")
    public void setDeleteCartsUsersInvalid(int id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("cart_id",id);
    }
}
