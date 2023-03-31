package starter.CookitAlta.StepDef.Followers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Followers.FollowersAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class PostFollow {
    @Steps
    FollowersAPI followersAPI;

    @Given("Post follow with valid id {int}")
    public void postFollowWithValidDataJson(int id) {
        followersAPI.setPostFollow(id);
    }

    @When("Send request post follow")
    public void sendRequestPostFollow() {
        SerenityRest.when().post(FollowersAPI.POST_FOLLOW);
    }

    @And("Validate json schema post follow")
    public void validateJsonSchemaPostFollow() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Followers/PostFollow.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Validate json schema invalid post follow")
    public void validateJsonSchemaInvalidPostFollow() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Followers/InvalidPostFollow.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post follow with invalid id {int}")
    public void postFollowWithInvalidValueDataJson(int id) {
        followersAPI.setPostFollow(id);
    }

    @Then("Status code follow should be {int} Bad Request")
    public void statusCodeFollowShouldBeBadRequest(int arg0) {
        SerenityRest.then().statusCode(arg0);
    }
}
