package starter.CookitAlta.CookitAPI.Users;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.Utils.Constant;

public class UsersAPI {
    public static String GET_USER = Constant.BASE_URL+"users";

    @Step("Get list User")
    public void getUser(){
        SerenityRest.given().headers("Authorization", "Bearer "+Constant.BEARER_TOKEN);
    }
}
