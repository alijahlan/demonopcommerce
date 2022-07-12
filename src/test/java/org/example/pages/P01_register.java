package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P01_register {

    public WebElement setRegisterLink(){

    return Hooks.driver.findElement(By.xpath("//a[@class='ico-register']"));
    }

    public WebElement genderMaleRadio(){
        return Hooks.driver.findElement(By.id("gender-male"));
    }

    public WebElement setFirstname(){
        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement setLastname(){
        return Hooks.driver.findElement(By.id("LastName"));
    }

    public Select setDay(){
        Select day = new Select(Hooks.driver.findElement(By.name("DateOfBirthDay")));
        return day;
    }

    public Select setMonth(){
        Select month = new Select(Hooks.driver.findElement(By.name("DateOfBirthMonth")));
        return month;
    }

    public Select setYear(){
        Select year = new Select(Hooks.driver.findElement(By.name("DateOfBirthYear")));
        return year;
    }

    public WebElement setEmail(){
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement setPassword(){
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement setConfirmPassword(){
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement setRegisterBtn(){
        return Hooks.driver.findElement(By.id("register-button"));
    }

    public WebElement getResult(){
        return Hooks.driver.findElement(By.className("result"));
    }

}

