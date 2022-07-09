package com.qa.stepDefinitions;

import com.qa.context.TestContext;
import com.qa.factory.PageFactoryManager;
import com.qa.pages.ProgramsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class ProgramsPageDefinition {

    private final ProgramsPage programsPage;
    private final TestContext context;

    public ProgramsPageDefinition(TestContext context) {
        this.context = context;
        programsPage = PageFactoryManager.getProgramsPage(context.driver);
    }

    @Given("user on Programs tab")
    public void user_on_programs_tab() {

    }
    @When("User clicks on New link")
    public void user_clicks_on_new_link() {
        programsPage.clickNewLink();
    }

    @When("user fills all details are")
    public void user_fills_all_details_are(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();
        programsPage.fillDetails(data.get(1).get(0),data.get(1).get(1),data.get(1).get(2),data.get(1).get(3),data.get(1).get(4),data.get(1).get(5),data.get(1).get(6),data.get(1).get(7), data.get(1).get(8),data.get(1).get(9),data.get(1).get(10),data.get(1).get(11),data.get(1).get(12),data.get(1).get(13), data.get(1).get(14),data.get(1).get(15),data.get(1).get(16),data.get(1).get(17),data.get(1).get(18),data.get(1).get(19),data.get(1).get(20));
        
    }
    @When("user clicks on Save button")
    public void user_clicks_on_save_button() {
        throw new io.cucumber.java.PendingException();
    }


    @Then("program should be created successfully")
    public void program_should_be_created_successfully() {

    }

}
