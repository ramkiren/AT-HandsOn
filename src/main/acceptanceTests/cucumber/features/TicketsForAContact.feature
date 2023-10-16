Feature: Testing Ticket Details API

  Scenario: Verify Ticket Details API Response
    Given the Ticket Details API is available
    When I send a GET request to the API
    Then the response status code should be 200
    And the response should contain JSON data
