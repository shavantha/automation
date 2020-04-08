Feature: Login functionality feature

  In order to do internet banking
  As a valid para bank customer
  I want to login successfully

Scenario Outline: login successfully

  Given I am in the login page of the para bank application
  When I enter valid <username> and <password>
  Then I should be taken to the overview page

Examples:
  |username|password|
  |"tester123"|"tester123"|