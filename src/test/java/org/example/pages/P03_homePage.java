package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P03_homePage {
    int mainItemIndex;
    boolean isHasChild;

    public Select getSelectOption() {
        return new Select(Hooks.driver.findElement(By.id("customerCurrency")));
    }

    public List<WebElement> productsPrice() {
        return Hooks.driver.findElements(By.xpath("//span[@class='price actual-price']"));
    }

    public WebElement searchTxtField() {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public WebElement searchBtn() {
        return Hooks.driver.findElement(By.xpath("//form[@id='small-search-box-form']//button[@type='submit']"));
    }

    public String getUrl() {
        return Hooks.driver.getCurrentUrl();
    }

    public List<WebElement> productsTitle() {
        return Hooks.driver.findElements(By.xpath("//h2[@class='product-title']//a"));
    }

    public WebElement skuLabel() {
        return Hooks.driver.findElement(By.xpath("//div[@class='sku']//span[@class='value']"));
    }


    //    hover Categories Feature
    public void categoriesMenu()  {
        Actions action = new Actions(Hooks.driver);
        //Thread.sleep(1000);
        List<WebElement> lis = Hooks.driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li"));

        mainItemIndex = (int) (Math.random() * lis.size());

        WebElement mainLi = lis.get(mainItemIndex);
        action.moveToElement(mainLi).perform();
         isHasChild = hasChildren(mainLi);
    }

    public String getSubCategory(){

        String subTitle;
        if (isHasChild){
            isHasChild = false;
        List<WebElement> as = Hooks.driver.findElements(By.xpath(String.format("//ul[@class='top-menu notmobile']/li[position()=%d]//ul//li", mainItemIndex + 1)));
        //System.out.println(as.get((int) (Math.random() * as.size())).getText());

        int subCategoryIndex = (int) (Math.random() * as.size());
        subTitle = as.get(subCategoryIndex).getText();
        as.get(subCategoryIndex).click();
        }
        else{
            WebElement catNoChild = Hooks.driver.findElement(By.xpath(String.format("//ul[@class='top-menu notmobile']/li[position()=%d]//a", mainItemIndex + 1)));
            subTitle = catNoChild.getText();
            catNoChild.click();
        }

        return  subTitle;
    }

    public WebElement getPageTitle() {
        //Thread.sleep(2000);
        return Hooks.driver.findElement(By.xpath("//div[@class='page-title']//h1"));
    }


    boolean hasChildren(WebElement node) {
        return node.findElements(By.xpath("./descendant-or-self::*")).size() > 2;
    }


//    Home page slider

    public List<WebElement> getSliders(){
        return Hooks.driver.findElements(By.xpath("//div[@id='nivo-slider']/a"));
    }

    public WebElement sliderControl(){
        return Hooks.driver.findElement(By.xpath("//div[@class='nivo-controlNav']//a[@rel='1']"));
    }


//    followUs Feature

    public WebElement getFacebookBtn(){
        return Hooks.driver.findElement(By.xpath("//li[@class=\"facebook\"]//a"));
    }
    public WebElement getTwitterBtn(){
        return Hooks.driver.findElement(By.xpath("//li[@class=\"twitter\"]//a"));
    }
    public WebElement getRSSBtn(){
        return Hooks.driver.findElement(By.xpath("//li[@class=\"rss\"]//a"));
    }
    public WebElement getYoutubeBtn(){
        return Hooks.driver.findElement(By.xpath("//li[@class=\"youtube\"]//a"));
    }
}

