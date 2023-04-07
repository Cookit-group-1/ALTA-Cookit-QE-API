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

public class UsersPostTransactionStepdef {
    @Steps
    TransactionApi transactionApi;


    // CREATE TRANSACTION
    @Given("Create users data transaction with valid token")
    public void createUsersDataTransactionWithValidToken() {
        File json = new File(Constant.JSON_REQUEST+"Transaction/UsersPostTransaction.json");
        transactionApi.postTransaction(json);
    }

    @When("Create users data request transaction")
    public void createUsersDataRequestTransaction() {
        SerenityRest.when().post(TransactionApi.GET_POST_TRANSACTION_USER);
    }

    @And("Validate json schema Create users transaction")
    public void validateJsonSchemaCreateUsersTransaction() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "Transaction/PostTransactionUsers.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Create users data transaction with invalid token")
    public void createUsersDataTransactionWithInvalidToken() {
        transactionApi.getTransaction(Constant.INVALID_TOKEN);
    }
}
