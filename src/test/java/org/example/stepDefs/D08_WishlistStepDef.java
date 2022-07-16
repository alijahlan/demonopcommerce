package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class D08_WishlistStepDef {

    P03_homePage homePage = new P03_homePage();

    SoftAssert softAssert = new SoftAssert();

    @Given("user click on the heart icon")
    public void user_click_on_the_heart_icon() throws InterruptedException {
        homePage.getHeartBtn().click();
        Thread.sleep(2000);
    }

    @Then("verify the success msg {string} and BGColor {string}")
    public void verify_the_success_msg(String expectedMsg, String expectedBGColor) {
        String actualMsg = homePage.getSuccessMsg().getText();
        String actualBGColor = homePage.getSuccessMsgParent().getCssValue("background-color");
        actualBGColor = Color.fromString(actualBGColor).asHex();

        softAssert.assertTrue(actualMsg.contains(expectedMsg));
        softAssert.assertEquals(actualBGColor,expectedBGColor);

        softAssert.assertAll();
    }


//    Check the qty of wishlist

    @When("user close the success msg bar")
    public void user_close_the_success_msg_bar() {
        homePage.getSuccessX().click();
    }

    @Then("verify the wishlist Qty bigger than zero")
    public void verify_the_wishlist_qty_bigger_than_zero() {
        String qty = homePage.getWishlistQty().getText();
        int qtyValue = Integer.parseInt(qty.replaceAll("[^0-9]",""));

        Assert.assertTrue(qtyValue>0);
    }

}
