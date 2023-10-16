Feature: Ticket Creation
  As a user, I want to create a ticket with mandatory fields, so that I can request support.

#  Scenario: Create a Ticket Successfully
#    Given I am on the ticket creation page
#    When I fill in the following details:
#      | Subject      | Your Subject    |
#      | Description  | Your Description |
#      | Priority     | High            |
#    And I submit the form
#    Then I should see the message "Ticket created successfully"


  Scenario: Create a Ticket with Missing or Invalid Information
    Given I am on the ticket creation page
    When I fill in the following details with missing or invalid information:
      | Subject      ||
      | Description  | Invalid data    |
      | Priority     | Invalid Priority |
    And I submit the form
    Then I should see an error message "Missing mandatory fields"
