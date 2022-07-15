package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D05_hoverCategoriesStepDef {
    String subCategoryName;
    P03_homePage homePage = new P03_homePage();

    @Given("User hover on random main category on the top menu")
    public void user_hover_on_random_main_category_on_the_top_menu() {
         homePage.categoriesMenu();
    }

    @When("user click on a sub category of product")
    public void user_click_on_a_sub_category_of_product() {
        subCategoryName = homePage.getSubCategory();
        //Thread.sleep(1000);
    }

    @Then("verify if the category title is matching")
    public void verify_if_the_category_title_is_matching()  {
        String expectedTitle = subCategoryName;
        String actualTitle = homePage.getPageTitle().getText();
        Assert.assertTrue(actualTitle.toLowerCase().trim().contains(expectedTitle.toLowerCase().trim()));
    }

}
