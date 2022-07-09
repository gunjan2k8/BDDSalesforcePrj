package com.qa.factory;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProgramsPage;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

	private static LoginPage loginPage;
    private static HomePage homePage;
	private static ProgramsPage programsPage;


	public static LoginPage getLoginPage(WebDriver driver) {
		return loginPage == null ? new LoginPage(driver) : loginPage;
	}


	public static HomePage getHomePage(WebDriver driver) {
		return homePage == null ? new HomePage(driver) : homePage;
	}

	public static ProgramsPage getProgramsPage(WebDriver driver) {
		return programsPage == null ? new ProgramsPage(driver) : programsPage;
	}
}
