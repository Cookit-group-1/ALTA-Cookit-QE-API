package starter.CookitAlta.CookitAPI.Transaction;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class TransactionApi {
    public static String GET_SINGGLE_USER = Constant.BASE_URL+"users";
    public static String PUT_USERS = Constant.BASE_URL+"users";
    public static String POST_LOGIN_USERS = Constant.BASE_URL+"login";


    // GET TRANSACTION
    @Step("Get users transaction with valid token")
    public void getFollower(String token){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }

    @Step("Get users transaction with invalid token")
    public void getWithoutokenFollower(){
        SerenityRest.given();
    }
    // END GET TRANSACTION


}
