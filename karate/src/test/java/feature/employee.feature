Feature: get employee details

  Background:
    * url 'http://dummy.restapiexample.com'
    * header Accept = 'application/json'
  Scenario: get all employee details
    Given  path '/api/v1/employees'
    When method get
    Then status 200
    And print 'Response is: ', response
    And match response contains {"data":[{id:"#notnull","employee_name":"Tiger Nixon","employee_salary":"320800","employee_age":"61","profile_image":""}]}