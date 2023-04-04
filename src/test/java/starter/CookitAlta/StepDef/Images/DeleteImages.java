package starter.CookitAlta.StepDef.Images;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Images.Image;


public class DeleteImages {
    @Steps
    Image image;

    @Given("Delete image with valid recipe id {int} and image id {int}")
    public void deleteImageWithValidRecipeIdAndImageId(int recipe_id, int image_id) {
        Image.deleteImageValid(recipe_id, image_id);
    }

    @When("Send request delete image")
    public void sendRequestDeleteImage() {
        SerenityRest.when().delete(Image.DELETE_IMAGES);
    }

    @Given("Delete image with invalid recipe id {string} and image id {string}")
    public void deleteImageWithInvalidRecipeIdAndImageId(String recipe_id, String image_id) {
        Image.deleteImageInvalid(recipe_id, image_id);
    }

    @Then("Status code should be {int} ok")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @Then("Status code should be {int} bad request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
}
