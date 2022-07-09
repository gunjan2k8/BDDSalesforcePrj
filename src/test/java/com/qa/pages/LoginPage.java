package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userTxtbox;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passTxtbox;

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginButton;

    public void enterUsername(String username) {
        clearAndSendKeys(userTxtbox, username);


    }

    public void enterPassword(String password) {
        clearAndSendKeys(passTxtbox, password);
    }

    public void clickLogin() {
        click(loginButton);
        //addCookies();
    }

}
