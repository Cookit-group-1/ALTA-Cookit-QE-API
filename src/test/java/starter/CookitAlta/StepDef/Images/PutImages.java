package starter.CookitAlta.StepDef.Images;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Images.Image;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class PutImages {

    @Steps
    Image image;

    //Put image with valid id and json file
    @Given("Put image with valid id recipe {int} and id image {int}")
    public void putImageWithValidIdRecipeAndIdImage(int recipe_id, int image_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Images/PutImage1.json");
        Image.putImage(recipe_id, image_id, jsonRequest);
    }

    @When("Send put image")
    public void sendPutImage() {
        SerenityRest.when().put(Image.PUT_IMAGES);
    }

    @And("Validate json schema put image valid")
    public void validateJsonSchemaPutImageValid() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Images/PutImageValid.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Put image with invalid id and valid json file
    @Given("Put image with valid id recipe {string} and id image {string}")
    public void putImageWithValidIdRecipeAndIdImage(String recipe_id, String image_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Images/PutImage1.json");
        Image.putImageInvalid(recipe_id, image_id, jsonRequest);
    }

    @And("Validate json schema put invalid image")
    public void validateJsonSchemaPutInvalidImage() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Images/PutImageInvalid.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Put image with valid id empty json
    @Given("Put image with valid id recipe {int} and id image {int} and empty json")
    public void putImageWithValidIdRecipeAndIdImageAndEmptyJson(int recipe_id, int image_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Images/PutImageEmpty.json");
        Image.putImage(recipe_id, image_id, jsonRequest);
    }

    @And("Validate json schema invalid put image empty")
    public void validateJsonSchemaInvalidPutImageEmpty() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Images/PutImageInvalid.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
