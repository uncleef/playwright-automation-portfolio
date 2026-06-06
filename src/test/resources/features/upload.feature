Feature: Upload file

  Scenario Outline: Select file from file System
    Given I navigate to the upload page
    When I select from file system the file "<fileName>"
    Then the selected expected file name is "<fileName>"

    Examples:
    | fileName |
    | text.txt |


  Scenario Outline: Select file from file System and upload
    Given I navigate to the upload page
    When I select from file system the file "<fileName>"
    Then the selected expected file name is "<fileName>"
    When I click the upload button
    Then file is uploaded

    Examples:
      | fileName |
      | text.txt |