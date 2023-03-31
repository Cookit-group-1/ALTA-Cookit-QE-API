package starter.CookitAlta.CookitAPI.Users;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;
import java.util.Map;

public class UsersAPI {
    public static String GET_SINGGLE_USER = Constant.BASE_URL+"{path}";
    public static String PUT_USERS = Constant.BASE_URL+"users";
    public static String GET_SEARCH_USERS = Constant.BASE_URL+"users?p=Tim Qe Joss";
//    public static String POST_USERS = Constant.BASE_URL + "";
//    public static String PUT_USERS = Constant.BASE_URL + "/";
//    public static String GET_ALL_USERS = Constant.BASE_URL + "/{path}";
//    public static String GET_USERS_BY_ID = Constant.BASE_URL + "/guru/{id}";
//    public static String DELETE_USERS = Constant.BASE_URL + "/guru";

    //    GET ALL USERS
    @Step("Get all data users with valid/invalid url")
    public void getAllDataUser(String path){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("path", path);
    }
    // END GET ALL USERS

    // PUT/UPDATE DATA USERS
    @Step("Put data users with valid url")
    public void putDataUser(String path){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("path", path);
    }


    @Step("Update users with valid token and valid form-data")
    public void setPutUsers(String username, String bio, String email, String password){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .formParam("username", username)
                .formParam("bio", bio)
                .formParam("email", email)
                .formParam("password", password);
    }

    @Step("Update users with invalid token and valid form-data")
    public void setPutUsersInvalid(String username, String bio, String email, String password){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.INVALID_TOKEN)
                .formParam("username", username)
                .formParam("bio", bio)
                .formParam("email", email)
                .formParam("password", password);
    }

    // END PUT/UPDATE DATA USERS



    // GET USERS data search with params
    @Step("Get Search Users by query parameter")
    public void getSearch(){
        SerenityRest.given()
                .headers("Authorization", "Bearer" + Constant.BEARER_TOKEN);

    }

    // END GET USERS data search with params
}

