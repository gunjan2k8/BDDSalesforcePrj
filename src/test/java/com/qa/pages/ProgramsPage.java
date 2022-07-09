package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgramsPage extends BasePage{

    public ProgramsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@title='New']")
    private WebElement newLink;

    @FindBy(xpath = "//input[@id='input-183']")
    private WebElement programTitle;


    @FindBy(xpath = "//textarea[@id='input-195']")
    private WebElement programDesc;

    @FindBy(xpath = "//input[@id='input-197']")
    private WebElement cfda;

    @FindBy(xpath = "//textarea[@id='input-201']")
    private WebElement programMeasure1;

    @FindBy(xpath = "//input[@id='input-204']")
    private WebElement keyPersonalTitle;


    @FindBy(xpath = "//textarea[@id='input-208']")
    private WebElement programMeasure2;


    @FindBy(xpath = "//input[@id='input-210']")
    private WebElement keyPersonalEmail;

    @FindBy(xpath = "//textarea[@id='input-214']")
    private WebElement programMeasure3;


    @FindBy(xpath = "//input[@id='input-216']")
    private WebElement keyPersonalPhone;

    @FindBy(xpath = "//textarea[@id='input-220']")
    private WebElement comments;

    @FindBy(xpath = "//input[@id='input-225']")
    private WebElement programStart;

    @FindBy(xpath = "//textarea[@id='input-232']")
    private WebElement approvalComments;

    @FindBy(xpath = "//input[@id='input-236']")
    private WebElement fiscalYearStart;


    @FindBy(xpath = "//input[@id='input-899']")
    private WebElement address1;

    @FindBy(xpath = "//input[@id='input-905']")
    private WebElement address2;

    @FindBy(xpath = "//input[@id='input-911']")
    private WebElement city;

    @FindBy(xpath = "//button[@id='combobox-button-920']")
    private WebElement state;

    @FindBy(xpath = "//input[@id='input-926']")
    private WebElement zip;

    @FindBy(xpath = "//input[@id='input-901']")
    private WebElement phone;

    @FindBy(xpath = "//input[@id='input-907']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='input-913']")
    private WebElement website;


    public void clickNewLink() {
        click(newLink);
        System.out.println("user clicks on new link");

    }

    public void fillDetails(String prgTitle,String prgDesc,String cfda1,String prgMeasure1,
                            String keyPerTitle, String prgMeasure2, String keyPerEmail,
                            String prgMeasure3, String keyPerPhone, String cmnt, String prgStart,
                            String approvalComm, String fiscalYrStart, String add1, String add2,
                            String city1, String state1, String zip1, String phone1,
                            String email1, String website1){
        clearAndSendKeys(programTitle,prgTitle);
        clearAndSendKeys(programDesc,prgDesc);
        clearAndSendKeys(cfda,cfda1);
        clearAndSendKeys(programMeasure1,prgMeasure1);
        clearAndSendKeys(keyPersonalTitle,keyPerTitle);
        scrollToElement(programMeasure2);
        clearAndSendKeys(programMeasure2,prgMeasure2);
        clearAndSendKeys(keyPersonalEmail,keyPerEmail);
        clearAndSendKeys(programMeasure3,prgMeasure3);
        clearAndSendKeys(keyPersonalPhone,keyPerPhone);
        clearAndSendKeys(comments,cmnt);
        clearAndSendKeys(programStart,prgStart);
        clearAndSendKeys(approvalComments,approvalComm);
        clearAndSendKeys(fiscalYearStart,fiscalYrStart);
        clearAndSendKeys(address1,add1);
        clearAndSendKeys(address2,add2);
        clearAndSendKeys(city,city1);
        clearAndSendKeys(state,state1);
        clearAndSendKeys(zip,zip1);
        clearAndSendKeys(phone,phone1);
        clearAndSendKeys(email,email1);
        clearAndSendKeys(website,website1);

       }


}
