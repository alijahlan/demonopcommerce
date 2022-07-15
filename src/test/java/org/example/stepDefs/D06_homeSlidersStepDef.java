package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D06_homeSlidersStepDef {
    P03_homePage homePage = new P03_homePage();

    @Given("user click first slide")
    public void user_click_first_slide() throws InterruptedException {
        Thread.sleep(1000);
        homePage.getSliders().get(0).click();
    }

    @Given("user click second slide")
    public void user_click_second_slide() throws InterruptedException {

        homePage.sliderControl().click();
        Thread.sleep(2000);
        homePage.getSliders().get(1).click();

    }

    @Then("verify if the redirect link is {string}")
    public void verify_if_the_redirect_link_is(String expectedValue) {
        String actualValue = homePage.getUrl();
        Assert.assertEquals(actualValue,expectedValue);
    }


}
