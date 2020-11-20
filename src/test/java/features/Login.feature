Feature: Application Login

  Scenario: Homepage login
    Given Intialize the browser with opera
    And Navigate to "http://advantageonlineshopping.com/#/" site
    And Click on the login header to enter credentials
    When User enters username "imtester" and password "qwertyQaz1"
    Then Verify user is successfully logged in