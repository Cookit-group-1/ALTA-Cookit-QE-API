package starter.CookitAlta.StepDef.Followers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Followers.FollowersAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class PostFollow {
    @Steps
    FollowersAPI followersAPI;

    @Given("Post follow with valid data json")
    public void postFollowWithValidDataJson() {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Followers/PostFollow.json");
        followersAPI.setPostFollow(jsonRequest);

    }

    @When("Send request post follow")
    public void sendRequestPostFollow() {
        SerenityRest.when().post(FollowersAPI.POST_FOLLOW);
    }

    @And("Validate json schema post follow")
    public void validateJsonSchemaPostFollow() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"PostFollow.json");
    }
}
