Feature: Application Login

  Scenario Outline: Homepage login
    Given Intialize the browser with opera
    And Navigate to "http://advantageonlineshopping.com/#/" site
    And Click on the login header to enter credentials
    When User enters username <username> and password <password>
    Then Verify user is successfully logged in

    Examples:
      | username  | password   |
      | imtester  | qwertyQaz1 |
      | imtester1 | qwertyQaz2 |

