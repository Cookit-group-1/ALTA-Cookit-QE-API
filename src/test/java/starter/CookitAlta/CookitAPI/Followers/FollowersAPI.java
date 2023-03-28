package starter.CookitAlta.CookitAPI.Followers;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class FollowersAPI {
    public static String POST_FOLLOW = Constant.BASE_URL+"users/followers";

    @Step("Post followers with valid json body")
    public void setPostFollow(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
