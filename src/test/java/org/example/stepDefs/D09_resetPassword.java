package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D09_resetPassword {
    P02_login login = new P02_login();
    SoftAssert softAssert = new SoftAssert();

    @Given("user click on login button")
    public void user_click_on_login_button() {
        login.getLoginLink().click();
    }

    @When("user click on Forgot password link")
    public void user_click_on_forgot_password_link() {
        login.resetPasswordLink().click();
    }

    @And("user enter valid {string}")
    public void user_enter_valid_email(String email) {
    login.emailField().sendKeys(email);
    }


    @And("click on recover button")
    public void click_on_recover_button() throws InterruptedException {
        login.recoverBtn().click();
        Thread.sleep(2000);
    }

    @Then("check the reset successfully")
    public void check_the_reset_successfully() {

        String expectedSuccessColor = "#4bb07a";
        String actualSuccessColor = login.getColorResetSuccess().getCssValue("background-color");
        actualSuccessColor = Color.fromString(actualSuccessColor).asHex();
        softAssert.assertEquals(actualSuccessColor,expectedSuccessColor);

        String expectedValue = "Email with instructions has been sent to you";
        String actualValue = login.getResetSuccess().getText();
        softAssert.assertTrue(actualValue.contains(expectedValue));

        softAssert.assertAll();


    }
}
