package com.seleniumtestframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private WebDriver driver;

    @FindBy(how = How.LINK_TEXT, using = "Form Authentication")
    WebElement loginLink;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage login(){
        loginLink.click();
        return new LoginPage(driver);
    }
}
