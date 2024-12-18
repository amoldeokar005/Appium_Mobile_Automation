
  Feature: Login Functionality

    Scenario Outline: User logs in with valid credentials
      Given User launches the application
      When  User enters the valid username "<Username>"
      And User enters the valid password "<Password>"
      And User clicks on the login button
      Then User should see a success message


      Examples:
      |    Username      |     Password   |
      |  standard_user   |  secret_sauce  |