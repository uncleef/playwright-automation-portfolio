Feature: Dynamic controls page

  Scenario: Remove checkbox
    Given I navigate to the dynamic controls page
    When I press the remove button
    Then the checkbox should be "not visible"
    When I press the add button
    Then the checkbox should be "visible"
    When I click the checkbox
    Then the checkbox should be "checked"


  Scenario: Enable text
    Given I navigate to the dynamic controls page
    Then text is "disabled"
    When I click the enable button
    Then text is "enabled"
    When I click the disable button
    Then text is "disabled"

