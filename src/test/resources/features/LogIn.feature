#Author: Prakopchyk Viktar
#Date 24.08.2022
@TestScenario
Feature: Log in user
  @SmokeTest
  Scenario: Check user login with valid credentials
    Given user is on log in page
    When user set user name and password
    And user click sign in button
    Then user is on main page