package com.qa.hooks;

import com.qa.context.TestContext;
import com.qa.factory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import static com.qa.constants.FrameworkConstants.*;

public class Hooks {

    private WebDriver driver;
    private final TestContext context;

    /**
     * Dependency Injection using Pico container
     */
    public Hooks(TestContext context) {
        this.context = context;
    }


    @Before
    public void before(Scenario scenario) {

        System.out.println(
                "BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());

        driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER, BROWSER_CHROME));
        context.driver = driver;

    }
}
