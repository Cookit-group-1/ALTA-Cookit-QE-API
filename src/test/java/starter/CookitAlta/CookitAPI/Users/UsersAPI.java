package starter.CookitAlta.CookitAPI.Users;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;
import java.util.Map;

public class UsersAPI {
    public static String GET_SINGGLE_USER = Constant.BASE_URL+"users";
    public static String PUT_USERS = Constant.BASE_URL+"users";
    public static String POST_LOGIN_USERS = Constant.BASE_URL+"login";
    public static String USERS_FOLLOWER = Constant.BASE_URL + "users/follower";
    public static String USERS_FOLLOWING = Constant.BASE_URL + "users/following";
    public static String USERS_UPGRADE = Constant.BASE_URL + "users/upgrade";
    public static String USERS_UPDATE = Constant.BASE_URL + "users";
    public static String POST_LOGIN = Constant.BASE_URL + "users";


    // LOGIN SCENARIO

    @Step("Post login with valid/invalid User")
    public void postLogin(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    // END LOGIN SCENARIO



    //    GET ALL USERS
    @Step("Get all data users with token")
    public void getAllDataUser(String token){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }

    @Step("Get data users with invalid token")
    public void getAllDataUser(){
        SerenityRest.given();
    }
    // END GET ALL USERS



    // PUT / UPDATE DATA USERS
    @Step("Upgrade new users with valid token")
    public void getUpdateUsers(File update){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(update);
    }

    @Step("Send users update with valid token")
    public void sendUpdateUsers(String token){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token)
                .put(UsersAPI.USERS_UPDATE);
    }


    // INVALID TOKEN UPGRADE
    @Step("Upgrade new users with invalid token")
    public void getUpdateUsersInvalid(File update){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(update);
    }

    @Step("Send users invalid token")
    public void sendUpdateUsersInvalid(String token){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token)
                .put(UsersAPI.USERS_UPDATE);
    }

    // END PUT / UPDATE DATA USERS

    // FOLLOWER
    @Step("Get users follower with valid token/Invalid Token")
    public void getFollower(String token){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }

    @Step("Get data users without token follower")
    public void getWithoutokenFollower(){
        SerenityRest.given();
    }
    // END FOLLOWER


    // FOLLOWING
    @Step("Get users following with valid token/Invalid Token")
    public void getFollowing(String token){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }

    @Step("Get data users without token following")
    public void getWithoutokenFollowing(){
        SerenityRest.given();
    }
    // END FOLLOWING

    // UPGRADE USERS
    @Step("Upgrade new users with valid token")
    public void getUpgradeUsers(File update){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(update);
    }

    @Step("Send users update with valid token")
    public void sendUpdate(String token){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token)
                .post(UsersAPI.USERS_UPGRADE);
    }


    // INVALID TOKEN UPGRADE
    @Step("Upgrade new users with invalid token")
    public void getUpgradeUsersInvalid(File update){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(update);
    }

    @Step("Send users invalid token")
    public void sendUpdateInvalid(String token){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token)
                .post(UsersAPI.USERS_UPGRADE);
    }
    // END INVALID TOKEN UPGRADE
    // END UPGrADE USERS

}

