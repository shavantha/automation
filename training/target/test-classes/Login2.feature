Feature: Login functionality feature

  In order to do internet banking
  As a valid para bank customer
  I want to login successfully

Scenario: login successfully

  Given I am in the login page of the para bank application
  When I enter valid Credentials
    |"tester123"|"tester123"
  Then I should be taken to the overview page

