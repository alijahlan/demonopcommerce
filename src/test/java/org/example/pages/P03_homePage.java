package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P03_homePage {

    public Select getSelectOption(){
        return new Select( Hooks.driver.findElement(By.id("customerCurrency")));
    }

    public List<WebElement> productsPrice(){
        return Hooks.driver.findElements(By.xpath("//span[@class='price actual-price']"));
    }

    public WebElement searchTxtField(){
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public WebElement searchBtn(){
        return Hooks.driver.findElement(By.xpath("//form[@id='small-search-box-form']//button[@type='submit']"));
    }

    public String getUrl(){
        return Hooks.driver.getCurrentUrl();
    }

    public List<WebElement> productsTitle(){
        return Hooks.driver.findElements(By.xpath("//h2[@class='product-title']//a"));
    }

    public WebElement skuLabel(){
        return Hooks.driver.findElement(By.xpath("//div[@class='sku']//span[@class='value']"));
    }
}

