package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class D03_currenciesStepDef {
    P03_homePage homePage = new P03_homePage();
    @Given("select the currency type Euro Symbol")
    public void select_the_currency_type_euro_symbol() throws InterruptedException {
        homePage.getSelectOption().selectByVisibleText("Euro");
        Thread.sleep(1000);
    }

    @Then("verify Euro Symbol is shown on the products in Home page")
    public void verify_euro_symbol_is_shown_on_the_products_in_home_page() {
        List<WebElement> productsPrice = homePage.productsPrice();

        if (!productsPrice.isEmpty()){
            for (WebElement product : productsPrice) {
                //System.out.println(product.getText());
                Assert.assertTrue(product.getText().contains("€"));
            }
        }
    }
}
