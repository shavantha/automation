Feature: Login functionality feature

  In order to do make a holiday tour
  As a valid newtours customer
  I want to login successfully

@LoginUser
Scenario Outline: login successfully

  Given I am in the login page of the newtours application
  When I enter valid <username> and <password>
  Then I should be taken to the overview page

Examples:
  |username|password|
  |"shavantha123"|"shavantha123"|


  @LogoutUser
  Scenario: logout successfully

    Given I am logged in
    When I click on logout button
    Then I should be logged out of the system