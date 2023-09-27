Feature: BookCart Application tests

  Background: 
    # This background section defines common steps that are executed before each scenario.
    Given when user navigates to the BookCart application
    Given user clicks on the login button

  Scenario: Login should be success
    # This scenario tests a successful login attempt.
    Given user enters the username
    Given user enters the password 
    When user clicks on Login button
    Then Login button should be success

  Scenario: Login should be Fail
    # This scenario tests a failed login attempt.
    Given user enters the invalid username 
    Given user enters the invalid password 
    When user clicks on Login button
    Then Login button should Fail
