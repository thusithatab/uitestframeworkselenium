package com.seleniumtestframework.pages;

import com.seleniumtestframework.base.TestBase;
import org.openqa.selenium.WebDriver;

public class LoginPage{

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void getTitle(){
        driver.getTitle();
    }



}
