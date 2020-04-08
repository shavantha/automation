Feature: get weather information of london

  Background:
    * url 'http://api.openweathermap.org'
    * header Accept = 'application/json'
    * header Authorization = 'Bearer e02dd23898c9e3611184996339c399e8'
  Scenario: get all employee details
    Given  path 'data/2.5/weather?id=2172797&appid=e02dd23898c9e3611184996339c399e8'
    When method get
    Then status 200
    And print 'Response is: ', response
