Feature: Checkbox page

  Scenario: Change status to checkboxes
    Given I navigate to the checkbox page
    Then the default status should be Checkbox1:unchecked, Checkbox2: checked
    When I click the first checkbox
    And I click the second checkbox
    Then the first checkbox expected status is "checked"
    And the second checkbox expected status is "unchecked"
