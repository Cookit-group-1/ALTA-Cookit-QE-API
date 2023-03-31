package starter.CookitAlta.StepDef.Carts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.CookitAlta.CookitAPI.Carts.CartsDeleteAPI;

public class CartsDeleteUsers {

    @Steps
    CartsDeleteAPI cartsDeleteAPI;


    @Given("Delete users cart id {int}")
    public void deleteUsersCart(int id){
        cartsDeleteAPI.setDeleteCartsUsers(id);
    }
    @When("Send request delete users cart")
    public void sendRequestDeleteUsersCart() {
        SerenityRest.when().delete(CartsDeleteAPI.DELETE_CARTS_USERS);
    }
//    NEGATIVE
    @Given("Delete users cart invalid id {int}")
    public void deleteUsersCartInvalidId(int id) {
        cartsDeleteAPI.setDeleteCartsUsersInvalid(id);
    }

    @When("Send request delete users cart invalid")
    public void sendRequestDeleteUsersCartInvalid() {
        SerenityRest.when().delete(CartsDeleteAPI.DELETE_CARTS_USERS);
    }
}
