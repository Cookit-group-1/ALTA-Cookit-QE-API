package starter.CookitAlta.StepDef.Transaction;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Transaction.TransactionApi;
import starter.CookitAlta.Utils.Constant;

import java.io.File;

public class UsersGetTransactionIDStepdef {
    @Steps
    TransactionApi transactionApi;

    // Transaction ID
    @Given("Get users data transaction ID with valid token")
    public void getUsersDataTransactionIDWithValidToken() {
        transactionApi.getTransactionID(Constant.BEARER_TOKEN);
    }

    @When("Get users data request transaction ID")
    public void getUsersDataRequestTransactionID() {
        SerenityRest.when().get(TransactionApi.GET_TRANSACTION_USER_ID);
    }

    @And("Validate json schema users transaction ID")
    public void validateJsonSchemaUsersTransactionID() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Transaction/GetTransactionUsers.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get users data transaction ID with invalid token")
    public void getUsersDataTransactionIDWithInvalidToken() {
        transactionApi.getTransactionID(Constant.INVALID_TOKEN);
    }
}
