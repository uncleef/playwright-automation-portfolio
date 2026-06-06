Feature: Check post APIs

  Scenario: check /posts GET api
    When I send a GET request to "/posts"
    Then the status is 200
    And the body is not null

  Scenario: check /posts/1 GET api
    When I send a GET request to "/posts/1"
    Then the status is 200
    And the title is not null

  Scenario: check /posts POST api
    When I send a POST request to "/posts"
    Then the status is 201
    And the body is not null
