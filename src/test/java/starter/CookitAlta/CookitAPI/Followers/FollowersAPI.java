package starter.CookitAlta.CookitAPI.Followers;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class FollowersAPI {
    public static String POST_FOLLOW = Constant.BASE_URL+"users/follow/{user_id}";
    public static String DELETE_FOLLOW = Constant.BASE_URL+"users/unfollow/{user_id}";

    @Step("Post followers with valid json body")
    public void setPostFollow(int user_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("user_id", user_id);
    }

    @Step("Delete following")
    public void setDeleteFollow(int user_id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .pathParam("user_id", user_id);
    }
}
