package com.seleniumtestframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@class='button secondary radius']")
    WebElement logoutButton;

    @FindBy(how = How.ID, using = "flash")
    WebElement flashMessage;

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFlashMessage(){
        return flashMessage.getText();
    }

    public LoginPage logout(){
        logoutButton.click();
        return new LoginPage(driver);
    }
}
