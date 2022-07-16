package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage homePage = new P03_homePage();
    ArrayList<String> tabs = new ArrayList<>();

    @Given("user click on facebook icon")
    public void user_click_on_facebook_icon() throws InterruptedException {
        homePage.getFacebookBtn().click();
        Thread.sleep(2000);
    }

    @Given("user click on twitter icon")
    public void user_click_on_twitter_icon() throws InterruptedException {
        homePage.getTwitterBtn().click();
         Thread.sleep(2000);
    }

    @Given("user click on rss icon")
    public void user_click_on_rss_icon() throws InterruptedException {
        homePage.getRSSBtn().click();
         Thread.sleep(2000);
    }

    @Given("user click on youtube icon")
    public void user_click_on_youtube_icon() throws InterruptedException {
        homePage.getYoutubeBtn().click();
         Thread.sleep(2000);
    }

    @Then("verify new tab link {string}")
    public void verify_new_tab_link(String tabLink) throws InterruptedException {


         tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        Assert.assertEquals(homePage.getUrl(), tabLink);


    }

    @And("close the current tab")
    public void close_the_current_tab() {
        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));

    }

}
