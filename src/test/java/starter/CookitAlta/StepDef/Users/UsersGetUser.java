package starter.CookitAlta.StepDef.Users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Users.UsersAPI;

public class UsersGetUser {
    @Steps
    UsersAPI usersAPI;
    @Given("Get user with valid data")
    public void getUserWithValidData() {
        usersAPI.getUser();
    }

    @When("Send request get user")
    public void sendRequestGetUser() {
        SerenityRest.when().get(UsersAPI.GET_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int status) {
        SerenityRest.then().statusCode(status);
    }
}
