@regression
Feature: Successful Login with Valid entries

  @smoke @demo
  Scenario: Login with valid username and password
    Given User navigates to the website
    When User enters <Username> as "praveen070112@gmail.com.dev1"
    And <Password> as "Human@123456"
    And User clicks on login button
    Then login must be successful.



