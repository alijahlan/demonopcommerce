package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class D04_searchStepDef {
    SoftAssert softAssert = new SoftAssert();

    P03_homePage homePage = new P03_homePage();

    @Given("user enter {string} in search field")
    public void user_enter_in_search_field(String productName) {
        homePage.searchTxtField().sendKeys(productName);
    }

    @When("user click on search button")
    public void user_click_on_search_button() {
        homePage.searchBtn().click();
    }

    @Then("verify the URl contains {string}")
    public void verify_the_url_contains(String productName) {
        String expectedURL = "https://demo.nopcommerce.com/search?q=" + productName;
        String actualURL = homePage.getUrl();
        Assert.assertEquals(actualURL, expectedURL);
        //softAssert.assertAll();

    }

    @And("verify results contains {string}")
    public void verify_results_contains(String productName) {
        for (WebElement item : homePage.productsTitle()) {
            Assert.assertTrue(item.getText().toLowerCase().contains(productName.toLowerCase()));
            //softAssert.assertAll();
        }
    }


    @And("user click on the product card")
    public void user_click_product_card() {
        for (WebElement item : homePage.productsTitle()) {
            item.click();
        }
    }

    @And("verify product sku contains {string}")
    public void verify_product_sku_contains(String sku) {
        Assert.assertTrue(homePage.skuLabel().getText().contains(sku));
    }
}
