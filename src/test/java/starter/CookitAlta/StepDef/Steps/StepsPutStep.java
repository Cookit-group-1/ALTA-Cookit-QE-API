package starter.CookitAlta.StepDef.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Steps.StepsAPI;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class StepsPutStep {
    @Steps
    StepsAPI stepsAPI;
    @Given("Put step with valid data recipe {int} steps {int}")
    public void putStepWithValidData(int recipe, int id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Steps/PutStep.json");
        stepsAPI.putStep(recipe,id,jsonRequest);

    }

    @When("Send request put step")
    public void sendRequestPutStep() {
        SerenityRest.when().put(StepsAPI.PUT_STEP);
    }

    @And("Validate json schema put step")
    public void validateJsonSchemaPutStep() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Steps/PutStep.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Validate json schema invalid put step")
    public void validateJsonSchemaInvalidPutStep() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Steps/InvalidPutStep.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Put step with recipe id {int} and steps id {int} and invalid json body")
    public void putStepWithInvalidJsonBody(int recipe, int id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Steps/InvalidPutStep.json");
        stepsAPI.putStep(recipe,id,jsonRequest);

    }

    @And("Validate json schema invalid json put step")
    public void validateJsonSchemaInvalidJsonPutStep() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Steps/InvalidPutStep.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
