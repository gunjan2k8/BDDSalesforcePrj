package com.qa.stepDefinitions;

import com.qa.context.TestContext;
import com.qa.factory.PageFactoryManager;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomePageDefinition {

    private final HomePage homePage;
    private final TestContext context;

    public HomePageDefinition(TestContext context) {
        this.context = context;
        homePage = PageFactoryManager.getHomePage(context.driver);
    }

    @Given("User on Home Page")
    public void user_on_home_page() {
        Assert.assertTrue(homePage.isProfileImgDisplayed());
    }


    @When("User clicks on Programs tab")
    public void user_clicks_on_programs_tab() {
        homePage.clickProgramsTab();
    }

    @When("user logged in and clicks on Programs tab")
    public void user_logged_in_and_clicks_on_programs_tab() {
        Assert.assertTrue(homePage.isProfileImgDisplayed());
        homePage.clickProgramsTab();
    }



    @Then("programs title should be displayed")
    public void programs_title_should_be_displayed() {
        Assert.assertTrue(homePage.isProgramsTitleDisplayed());
    }

    @Then("user must be on Home Page")
    public void user_must_be_on_home_page() {
        Assert.assertTrue(homePage.isProfileImgDisplayed());
        // Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.getNotice());

    }


}
