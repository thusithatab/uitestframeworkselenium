package com.seleniumframework.tests;

import com.seleniumtestframework.base.TestBase;
import com.seleniumtestframework.pages.LoginPage;
import com.seleniumtestframework.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest  extends TestBase {

    @Test
    public void testLogin(){

        LoginPage loginPage = basePage.login();
        SecureAreaPage secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(secureAreaPage.getFlashMessage().contains("You logged into a secure area!"), "Alert text is incorrect");
        secureAreaPage.logout();

    }
}
