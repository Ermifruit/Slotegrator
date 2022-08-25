#Author: Prakopchyk Viktar
#Date 24.08.2022
@TestScenario
Feature: Open list of players
  @FunctionalTest
  Scenario: Open list of players
    Given user is logged in and is on the main page
    When user click on icon player management
    Then user can download CSV file