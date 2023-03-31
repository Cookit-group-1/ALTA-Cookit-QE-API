package starter.CookitAlta.StepDef.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Fields;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Steps.StepsAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class StepsPostStep {
    @Steps
    StepsAPI stepsAPI;

    @Given("Post step with valid data parameter {int}")
    public void postStepWithValidData(int id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Steps/PostStep.json");
        stepsAPI.postStep(id,jsonRequest);

    }

    @When("Send request post steps")
    public void sendRequestPostSteps() {
        SerenityRest.when().post(StepsAPI.POST_STEP);
    }

    @And("Validate json schema post step")
    public void validateJsonSchemaPostStep() {
        File jsonResponse = new File(Constant.JSON_SCHEMA+"Steps/PostStep.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonResponse));
    }

    @Given("Post step with invalid paramater {int}")
    public void postStepWithInvalidParamater(int id) {
        File jsonReq = new File(Constant.JSON_REQUEST+"Steps/PostStep.json");
        stepsAPI.postStep(id,jsonReq);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeUnauthorized(int status) {
        SerenityRest.then().statusCode(status);
    }

    @And("Validate json schema invalid post step")
    public void validateJsonSchemaInvalidPostStep() {
        File jsonSchem = new File(Constant.JSON_SCHEMA+"Steps/InvalidPostStep.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchem));
    }

    @Given("Post step with invalid json body and valid id {int}")
    public void postStepWithInvalidJsonBody(int id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Steps/InvalidPostStep.json");
        stepsAPI.postStep(id,jsonRequest);
    }

}
