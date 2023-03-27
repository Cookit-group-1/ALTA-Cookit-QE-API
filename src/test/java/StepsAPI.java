import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class StepsAPI {
    @Given("Insert steps with valid data parameter and json")
    public void insertStepsWithValidDataParameterAndJson(int id) {
    }

    @When("Send request post to insert steps")
    public void sendRequestPostToInsertSteps() {
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int arg0) {
    }

    @And("Validate json schema")
    public void validateJsonSchema() {
    }
}
