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

public class StepsDeleteStep {
    @Steps
    StepsAPI stepsAPI;

    @Given("Delete steps with valid data recipe {int} steps {int}")
    public void deleteStepsWithValidDataRecipeSteps(int arg0, int arg1) {
        stepsAPI.deleteStep(arg0,arg1);
    }

    @When("Send request delete step")
    public void sendRequestDeleteStep() {
        SerenityRest.when().delete(StepsAPI.DELETE_STEP);
    }

    @And("Validate json schema delete step")
    public void validateJsonSchemaDeleteStep() {
            File jsonSchem = new File(Constant.JSON_SCHEMA+"Steps/DeleteStep.json");
            SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchem));
        }
}
