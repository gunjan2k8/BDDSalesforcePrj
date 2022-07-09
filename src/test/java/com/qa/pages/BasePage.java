package com.qa.pages;

import com.qa.utils.ConfigLoader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.qa.constants.FrameworkConstants.ATTRIBUTE_VALUE;
import static com.qa.constants.FrameworkConstants.EXPLICIT_WAIT;

import java.io.*;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		PageFactory.initElements(driver, this);
	}

	public void loadUrl() {
		driver.get(ConfigLoader.getInstance().getBaseUrl());
	}


	public void waitForOverlaysToDisappear(By overlay) {
		List<WebElement> overlays = driver.findElements(overlay);
		System.out.println("OVERLAY SIZE" + overlays.size());
		if (overlays.size() > 0) {
			wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("OVERLAYS INVISIBLE");
		} else {
			System.out.println("OVERLAY NOT FOUND");
		}
	}

	public void clearAndSendKeys(WebElement element, String value) {
		element = waitForElementVisibility(element);
		element.clear();
		element.sendKeys(value);
	}

	public void addCookies(){
		// create file named Cookies to store Login Information
		File file = new File("Cookies.data");
		try
		{
			// Delete old file if exists
			file.delete();
			file.createNewFile();
			FileWriter fileWrite = new FileWriter(file);
			BufferedWriter Bwrite = new BufferedWriter(fileWrite);
			// loop for getting the cookie information

			// loop for getting the cookie information
			for(Cookie ck : driver.manage().getCookies())
			{
				Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
				Bwrite.newLine();
			}
			Bwrite.close();
			fileWrite.close();

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

    public void getCookeis(){
	try{

		File file = new File("Cookies.data");
		FileReader fileReader = new FileReader(file);
		BufferedReader Buffreader = new BufferedReader(fileReader);
		String strline;
		while((strline=Buffreader.readLine())!=null){
			StringTokenizer token = new StringTokenizer(strline,";");
			while(token.hasMoreTokens()){
				String name = token.nextToken();
				String value = token.nextToken();
				String domain = token.nextToken();
				String path = token.nextToken();
				Date expiry = null;

				String val;
				if(!(val=token.nextToken()).equals("null"))
				{
					expiry = new Date(val);
				}
				Boolean isSecure = new Boolean(token.nextToken()).
						booleanValue();
				Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
				System.out.println(ck);
				driver.manage().addCookie(ck); // This will add the stored cookie to your current session
			}
		}
	}catch(Exception ex){
		ex.printStackTrace();
	}
}

	public void click(WebElement element) {
		waitForElementToBeClickable(element).click();
	}

	public void clickJS(WebElement element) {
		waitForElementToBeClickable(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}



	public void click(By by) {
		waitForElementToBeClickable(by).click();
	}

	public boolean isDisplayed(WebElement element) {
		element = waitForElementVisibility(element);
		try{
		element.isDisplayed();
		return true;}
		catch (Throwable t) {
			return false;
		}
	}



	public WebElement waitForElementVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitForElementToBeClickable(By by) {
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getElementText(WebElement element) {
		return waitForElementVisibility(element).getText();
	}

	public String getElementElementAttribute_Value(WebElement element) {
		return waitForElementVisibility(element).getAttribute(ATTRIBUTE_VALUE);
	}

	public String getElementElementCustomAttribute(WebElement element, String customAttribute) {
		return waitForElementVisibility(element).getAttribute(customAttribute);
	}

}
