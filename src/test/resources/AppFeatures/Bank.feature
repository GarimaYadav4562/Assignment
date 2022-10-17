Feature: Bank feature

Scenario: Register User Page
Given user is on register page
Then page title should be "ParaBank | Register for Free Online Account Access"

Scenario: Pay Bill
Given user is on register page
When user is registered
And page title should be "ParaBank | Customer Created"
Then user pays bill succesfully