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

public class UsersGetTransactionStepdef {
    @Steps
    TransactionApi transactionApi;

    // transaction

    @Given("Get users data transaction with valid token")
    public void getUsersDataTransactionWithValidToken() {
        transactionApi.getTransaction(Constant.BEARER_TOKEN);
    }

    @When("Get users data request transaction")
    public void getUsersDataRequestTransaction() {
        SerenityRest.when().get(TransactionApi.GET_POST_TRANSACTION_USER);
    }

    @And("Validate json schema users transaction")
    public void validateJsonSchemaUsersTransaction() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Transaction/GetTransactionIdUsers.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get users data transaction with invalid token")
    public void getUsersDataTransactionWithInvalidToken() {
        transactionApi.getTransaction(Constant.INVALID_TOKEN);
    }
}
