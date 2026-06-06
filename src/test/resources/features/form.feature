Feature: Forgot password form

  Scenario: Submit forgot password form with valid email
    Given I navigate to the forgot password page
    When I submit the email "test@example.com"
    Then I should see a confirmation message