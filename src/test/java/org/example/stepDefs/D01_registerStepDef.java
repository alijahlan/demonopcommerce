package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {

    SoftAssert softAssert;
    P01_register registerPage = new P01_register();

    @Given("user go to register page")
    public void goRegisterPage() {

        registerPage.setRegisterLink().click();
    }

    @When("user select gender type")
    public void user_select_gender_type() throws InterruptedException {
        registerPage.genderMaleRadio().click();
        //Thread.sleep(1000);
    }

    @And("user enter first name {string} and last name {string}")
    public void user_enter_first_name_and_last_name(String firstname, String lastname) {
        registerPage.setFirstname().sendKeys(firstname);
        registerPage.setLastname().sendKeys(lastname);
    }

    @And("user enter date of birth")
    public void user_enter_date_of_birth() {
        registerPage.setDay().selectByValue("12");
        registerPage.setMonth().selectByValue("12");
        registerPage.setYear().selectByValue("1990");
    }

    @And("user enter email {string} field")
    public void user_enter_email_field(String email) {
    registerPage.setEmail().sendKeys(email);
    }

    @And("user fills Password fields {string} {string}")
    public void user_fills_password_fields(String password, String confirmPassword) {
    registerPage.setPassword().sendKeys(password);
        registerPage.setConfirmPassword().sendKeys(confirmPassword);

    }

    @Then("user clicks on register button")
    public void user_clicks_on_register_button() {
    registerPage.setRegisterBtn().click();

    }

    @And("success message is displayed")
    public void success_message_is_displayed() {
    String expectedResult = "Your registration completed";
    String actualResult = registerPage.getResult().getText();
    String color = registerPage.getResult().getCssValue("color");

        softAssert = new SoftAssert();
        softAssert.assertEquals(expectedResult,actualResult,"Check for success register message");
        softAssert.assertEquals(color , "rgba(76, 177, 124, 1)","Check success message color");

        softAssert.assertAll();
    }
}
