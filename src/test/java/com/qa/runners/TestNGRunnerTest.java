package com.qa.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "html:target/cucumber/cucumber.html" ,
                "me.jvt.cucumber.report.PrettyReports:target/cucumber/"
        },
        glue = { "com.qa" },
        features = {"src/test/resources/features/programs.feature"},
        tags = "@smoke"
)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {


}
