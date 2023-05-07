Feature: Application Login

Scenario: Login with valid credentials

Given open any btowser
And Navigate to login page
When User enters username as "din@gmail.com" and password as "din123" in to fields
And User clicks on login button
Then verify user is able to successfully login 