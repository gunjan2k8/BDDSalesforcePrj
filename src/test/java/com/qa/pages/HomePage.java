package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@title='User']")
    private WebElement profileImg;

    @FindBy(xpath = "//span[@class='slds-truncate'][normalize-space()='Programs']")
    private WebElement programsTab;

    @FindBy(xpath = "//span[@class='slds-var-p-right_x-small']")
    private WebElement programsTitle;


    public boolean isProfileImgDisplayed() {
       boolean value= isDisplayed(profileImg);
       return value;
    }

    public void clickProgramsTab() {
        clickJS(programsTab);
    }

    public boolean isProgramsTitleDisplayed() {
        boolean value= isDisplayed(programsTitle);
        return value;
    }

}
