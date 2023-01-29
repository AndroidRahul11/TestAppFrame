package com.qa.Test;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginTest {

    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage();
    }
    @Test
    public void Invalidusername() {
        loginPage.enterUserName("Testusername");
        loginPage.enterPassword("testpass");
        loginPage.clickLogin();
    }
}
