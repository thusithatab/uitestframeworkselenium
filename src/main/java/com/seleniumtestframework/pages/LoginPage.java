package com.seleniumtestframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

    private WebDriver driver;
    @FindBy(how = How.ID, using = "username")
    WebElement username;

    @FindBy(how = How.ID, using = "password")
    WebElement password;

    @FindBy(how = How.XPATH, using = "//i[contains(text(),'Login')]")
    WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username){
        this.username.sendKeys(username);
    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public SecureAreaPage login(String username, String password){
            enterUsername(username);
            enterPassword(password);
            clickLoginButton();

            return new SecureAreaPage(driver);
        }

}
