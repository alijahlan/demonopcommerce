package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {

public WebElement getLoginLink(){
    return Hooks.driver.findElement(By.xpath("//a[@class='ico-login']"));
}

    public WebElement getEmailTxtField(){
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement getPasswordTxtField(){
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement getLoginBtn(){
        return Hooks.driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
    }

public String getUrl(){
    return Hooks.driver.getCurrentUrl();
}

public WebElement getMyAccount(){
    return Hooks.driver.findElement(By.xpath("//a[@class='ico-account']"));
}

public WebElement getLoginFailMsg(){
    return Hooks.driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
}


// for reset password

    public WebElement resetPasswordLink(){
        return Hooks.driver.findElement(By.xpath("//span[@class='forgot-password']//a"));
    }

    public WebElement emailField(){
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement recoverBtn(){
        return Hooks.driver.findElement(By.name("send-email"));
    }

    public WebElement getColorResetSuccess(){
        return Hooks.driver.findElement(By.xpath("//div[@id='bar-notification']//div[@class='bar-notification success']"));
    }

    public WebElement getResetSuccess(){
        return Hooks.driver.findElement(By.xpath("//div[@id='bar-notification']//p[@class='content']"));
    }


}
