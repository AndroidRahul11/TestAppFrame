package com.qa.pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.mobile.BaseTest;


public class ProductPage extends BaseTest {

    @AndroidFindBy(xpath = "xyz") private WebElement ProductTitle;

    public String ProductTitle() {
       return getAttribute(ProductTitle, "text");
    }
}

