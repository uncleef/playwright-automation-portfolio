Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given I navigate to the login page
    When I login with username "tomsmith" and password "SuperSecretPassword!"
    Then I should see the success message

  Scenario: Failed login with invalid credentials
    Given I navigate to the login page
    When I login with username "wronguser" and password "wrongpassword"
    Then I should see an error message