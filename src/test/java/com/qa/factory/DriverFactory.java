package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.qa.constants.FrameworkConstants.BROWSER_CHROME;
import static com.qa.constants.FrameworkConstants.BROWSER_FIREFOX;
import static com.qa.constants.FrameworkConstants.BROWSER_SAFARI;
import static com.qa.constants.FrameworkConstants.BROWSER_EDGE;

public class DriverFactory {

	public static WebDriver initializeDriver(String browser) {
		WebDriver driver;
		switch (browser) {

		case BROWSER_CHROME: {
			WebDriverManager.chromedriver().browserVersion("103.0.5060.53").setup();
			//ChromeOptions options= new ChromeOptions();
			// type chrome://version/ on chrome browser, copy profile path
			//options.addArguments("user-data-dir=C:\\Users\\gunja\\AppData\\Local\\Google\\Chrome\\User Data\\Default");

			/* Storing the Chrome Profile Path in Chrome_Profile_Path variable. */
			String Chrome_Profile_Path = "C:\\Users\\gunja\\AppData\\Local\\Google\\Chrome\\User Data\\Default";

			/* Creating an instance of ChromeOptions (i.e objChrome_Profile) */
			ChromeOptions Chrome_Profile = new ChromeOptions();

			/* Disabling the chrome browser extensions */
			Chrome_Profile.addArguments("chrome.switches","--disable-extensions");

			/* Adding Chrome profile by .addArguments to objChrome_Profile  */
			Chrome_Profile.addArguments("user-data-dir=" + Chrome_Profile_Path);

			/*Initializing the Webdriver instance (i.e. driver) to open Chrome Browser and passing the Chrome Profile as argument */
			driver = new ChromeDriver(Chrome_Profile);

			//driver = new ChromeDriver();
			break;
		}
		case BROWSER_FIREFOX: {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		case BROWSER_SAFARI: {
			driver = new SafariDriver();
			break;
		}
		case BROWSER_EDGE: {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		default:
			throw new IllegalStateException("INVALID BROWSER: " + browser);
		}
		driver.manage().window().maximize();
		return driver;
	}
}
