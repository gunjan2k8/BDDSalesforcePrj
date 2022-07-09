@regression
Feature: switch to tabs

  @smoke @demo
  Scenario: switch to Programs tab
    Given User on Home Page
    When User clicks on Programs tab
    Then programs title should be displayed