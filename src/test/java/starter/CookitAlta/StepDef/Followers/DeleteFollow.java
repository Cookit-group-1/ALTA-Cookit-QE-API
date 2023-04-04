package starter.CookitAlta.StepDef.Followers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Followers.FollowersAPI;

public class DeleteFollow {
    @Steps
    FollowersAPI followersAPI;
    @Given("Delete follow with valid data follow id {int}")
    public void deleteFollowWithValidDataFollowId(int arg0) {
        followersAPI.setDeleteFollow(arg0);
    }

    @When("Send request delete follow")
    public void sendRequestDeleteFollow() {
        SerenityRest.when().delete(FollowersAPI.DELETE_FOLLOW);
    }

    @Given("Delete follow with invalid data follow id {int}")
    public void deleteFollowWithInvalidDataFollowId(int arg0) {
        followersAPI.setDeleteFollow(arg0);
    }
}
