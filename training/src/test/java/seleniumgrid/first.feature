#feature file
Feature: Login functionality feature

  In order to do make a holiday tour
  As a valid  customer
  I want to login successfully

  Scenario Outline: login successfully

    Given I am in the login page of the application
    When I enter valid <username> and <password>
    Then I should be taken to the overview page

    Examples:
      |username|password|
      |"shavantha123"|"shavantha123"|

