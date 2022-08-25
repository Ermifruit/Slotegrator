#Author: Prakopchyk Viktar
#Date 24.08.2022
@TestScenario
Feature: Sort column
  @FunctionalTest
  Scenario: Sort by any column and check sorting
    Given user is on player management page
    When user sort table by name
    Then check if the table is sorted