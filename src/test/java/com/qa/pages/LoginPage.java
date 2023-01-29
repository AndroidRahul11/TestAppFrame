package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.mobile.BaseTest;

public class LoginPage extends BaseTest {

    @AndroidFindBy(accessibility = "open menu") private WebElement Menubtn;
    @AndroidFindBy(accessibility = "open menu") private WebElement userNameTxt;
    @AndroidFindBy(accessibility="menu item log in") private WebElement Login;
    @AndroidFindBy(accessibility = "Username input field") private WebElement usernameTxtfld;
    @AndroidFindBy(accessibility = "Password input field") private WebElement passwordTxtfld;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"generic-error-message\"]/android.widget.TextView") private WebElement errortxt;
    @AndroidFindBy(accessibility = "menu item log in") private WebElement pressLoginBtn;

    public LoginPage accessLoginPage() {
        click(Menubtn);
        return this;
    }
    public LoginPage SelectLoginPage()
    {
        click(Login);
        return new LoginPage();
    }

    public LoginPage enterUserName(String username) {
        sendKeys(usernameTxtfld, username);
        return this;
    }
    public LoginPage enterPassword(String password) {
        sendKeys(passwordTxtfld, password);
        return this;
    }

    public String getErrorTxt(){
        return getAttribute(errortxt, "text");
    }

    public ProductPage clickLogin() {
        click(pressLoginBtn);
        return new ProductPage();

    }
}
