package starter.CookitAlta.CookitAPI.Transaction;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class TransactionApi {
    public static String GET_POST_TRANSACTION_USER = Constant.BASE_URL+"users/transactions";
    public static String GET_TRANSACTION_USER_ID = Constant.BASE_URL+"users/transactions/transactionDetails/186";


    // GET TRANSACTION
    @Step("Get users transaction with valid token/invalid")
    public void getTransaction(String token){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }
    // END GET TRANSACTION

    // POST TRANSACTION
    @Step("Post login with valid/invalid User")
    public void postTransaction(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN);
    }
    // END POST TRANSACTION

    // GET USERS TRANSACTION ID
    @Step("Get users transaction ID with valid token/invalid")
    public void getTransactionID(String token){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }



}
