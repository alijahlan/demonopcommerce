package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;

public class D02_loginStepDef {

    P02_login login = new P02_login();
    SoftAssert softAssert = new SoftAssert();

    @Given("user go to login page")
    public void user_go_to_login_page() {
        login.getLoginLink().click();
    }

    @When("user login with valid {string} and {string}")
    public void user_login_with_valid(String email, String password) {
        login.getEmailTxtField().sendKeys(email);
        login.getPasswordTxtField().sendKeys(password);
    }

    @When("user login with invalid {string} and {string}")
    public void user_login_with_invalid(String email, String password) {
        login.getEmailTxtField().sendKeys(email);
        login.getPasswordTxtField().sendKeys(password);
    }

    @And("user press on login button")
    public void user_press_on_login_button() {
        login.getLoginBtn().click();
    }

    @Then("user login to the system successfully")
    public void user_login_to_the_system_successfully() {
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = login.getUrl();

        softAssert.assertEquals(actualUrl, expectedUrl);

        softAssert.assertTrue(login.getMyAccount().isDisplayed());

        softAssert.assertAll();

    }

    @Then("user could not login to the system")
    public void user_could_not_login_to_the_system() {

        String expectedResult = "Login was unsuccessful";
        String actualResult = login.getLoginFailMsg().getText();
        softAssert.assertTrue(actualResult.contains(expectedResult));

        String expectedColor = "#e4434b";
        String actualColor = login.getLoginFailMsg().getCssValue("color");

        actualColor = Color.fromString(actualColor).asHex();

        softAssert.assertEquals(actualColor,expectedColor);

        softAssert.assertAll();

    }
}
