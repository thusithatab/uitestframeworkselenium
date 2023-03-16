package com.seleniumframework.tests;

import com.seleniumtestframework.base.TestBase;
import com.seleniumtestframework.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest  extends TestBase {

    @Test
    public void testLogin()   {

        LoginPage loginPage = basePage.login();
    }
}
