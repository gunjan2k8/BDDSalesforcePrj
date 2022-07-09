@regression
Feature: Create New Program in Programs tab
  Description: The purpose of this feature is to test the Programs feature

  Background: : Login with valid username and password
    Given User navigates to the website
    When User enters <Username> as "praveen070112@gmail.com.dev1"
    And <Password> as "Human@123456"
    And User clicks on login button
    And user logged in and clicks on Programs tab
    Then programs title should be displayed

   @smoke @demo
  Scenario: Create New program
    Given User on Home Page
     When User clicks on Programs tab
     And User clicks on New link
     And user fills all details are
      | programTitle | programDesc | cfda  | programMeasure1 | keyPersonalTitle  | programMeasure2 | keyPersonalEmail   | programMeasure3  | keyPersonalPhone | comments | programStart  | approvalComments | fiscalYearStart  | address1 | address2   | city | state | zip  | phone | email|website|
      | programTitle1 | programDesc | 45.123  | STEM education1 | gunjan  | diabetes awareness2 | gunjan@gmail.com   | building infrastructure1  | 2222233333 | comments | 6/1/2023  | approvalComments | 2023  | address1 | address2   | Fairfax | state | 22031  | 15085420611 | shwetamishra3111@gmail.com|www.website.com|
     And user clicks on Save button
    Then program should be created successfully
