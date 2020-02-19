Feature: To test login functionality of NopCommerse website

Scenario: Verify login functionality

Given open nopCommerse website
When user enters "admin@yourstore.com" and "admin"
And user clicks on Login button
Then login is successfull

Scenario Outline: Verify login functionality

Given open nopCommerse website
When user enters "<username>" and "<password>"
And user clicks on Login button
Then login is successfull

Examples:
|username           |password|
|admin@yourstore.com|admin   |
|admin@yourstore.com|admin123|