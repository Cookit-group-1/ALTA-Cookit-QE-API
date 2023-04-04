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

public class PostImages {

    @Steps
    Image image;

    //Post image with valid id and json file
    @Given("Post image with valid id recipe {int}")
    public void postImageWithValidIdRecipe(int recipe_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Images/PostImage1.json");
        Image.postImage(recipe_id, jsonRequest);
    }

    @When("Send post image")
    public void sendPostImage() {
        SerenityRest.when().post(Image.POST_IMAGE);
    }

    @And("Validate json schema post image valid")
    public void validateJsonSchemaPostImageValid() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Images/PostImageValid.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //ost image with invalid id and valid json file
    @Given("Post image with valid id recipe {string}")
    public void postImageWithValidIdRecipe(String recipe_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Images/PostImage1.json");
        Image.postImageInvalid(recipe_id, jsonRequest);
    }

    @And("Validate json schema post invalid image")
    public void validateJsonSchemaPostInvalidImage() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Images/PostImageInvalid.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Post image with empty json
    @Given("Post image with valid id recipe {int} and empty json")
    public void postImageWithValidIdRecipeAndEmptyJson(int recipe_id) {
        File jsonRequest = new File(Constant.JSON_REQUEST+"Images/PostImageEmpty.json");
        Image.postImage(recipe_id, jsonRequest);
    }


    @And("Validate json schema invalid post image empty")
    public void validateJsonSchemaInvalidPostImageEmpty() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"Images/PostImageInvalid.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}
