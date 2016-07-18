@tag
Feature: Login Skype Page

  @tag4
  Scenario: Login with correct user name and password
    Given Open Login skype page
     When "nhatdhse" logged in with password is "dung2192"
     Then I verify page title is "Skype My Account"
  
  @tag5
  Scenario Outline: Login Skype
    Given Open Login skype page
     When I am input username is "<User Name>"
      And I am input password is "<Password>"
      And user click Signin button
     Then I verify the error message is "<Error Message>"
  
    Examples: 
      | User Name    | Password  | Error Message                                                                       | 
      | pinkgirl6103 |           | Incorrect password. Please try again.                                               | 
      |              | testpwasd | You did not enter your Skype Name.                                                  | 
      | bla          | bla       | Signing in failed. Please double-check your Skype Name and re-enter your password.​  | 
  
  @tag6
  Scenario: Login Skype
    Given Open Login skype page
     When I fill the login from
      | User Name | Password | 
      | balbla    | balala   | 
     Then I verify page title is "<Error Message>"
  
  
