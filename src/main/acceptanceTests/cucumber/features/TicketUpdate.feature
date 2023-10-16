Feature: Testing Ticket Update Servlet
#
#  Scenario: Updating a ticket with valid information
#    Given I am on the ticket update page
#    When I fill in the following update details:
#      | id      | 12345        |
#      | subject | Updated Ticket |
#      | description | This is an updated test |
#      | priority | Low           |
#    And I submit the update form
#    Then  I should see the message for update message "Ticket updated successfully"
#
#  Scenario: Updating a ticket with missing or invalid information
#    Given I am on the ticket update page
#    When I fill in the following details with missing or invalid information:
#      | id      |              |
#      | subject | Updated Ticket |
#      | description | This is an updated test |
#      | priority | Low           |
#    And I submit the update form
#    Then I should see an error message "Invalid input"
