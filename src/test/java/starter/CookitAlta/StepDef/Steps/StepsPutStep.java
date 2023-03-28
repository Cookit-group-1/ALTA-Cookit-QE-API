package starter.CookitAlta.StepDef.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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
    }
}
