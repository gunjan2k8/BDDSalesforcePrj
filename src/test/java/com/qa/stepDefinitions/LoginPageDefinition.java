package com.qa.stepDefinitions;

import com.qa.context.TestContext;
import com.qa.factory.PageFactoryManager;
import com.qa.pages.LoginPage;
import com.qa.pages.ProgramsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginPageDefinition {

    private final LoginPage loginPage;
    private final TestContext context;

    public LoginPageDefinition(TestContext context) {
        this.context = context;
        loginPage = PageFactoryManager.getLoginPage(context.driver);
    }


    @Given("User navigates to the website")
    public void user_navigates_to_the_website() {
        loginPage.loadUrl();
    }

    @When("User enters <Username> as {string}")
    public void user_enters_username_as(String string) {
       loginPage.enterUsername(string);
    }

    @When("<Password> as {string}")
    public void password_as(String string) {
        loginPage.enterPassword(string);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("login must be successful.")
    public void login_must_be_successful() throws InterruptedException {
       loginPage.clickLogin();
       Thread.sleep(100000000);
       // Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.getNotice());

    }


}
