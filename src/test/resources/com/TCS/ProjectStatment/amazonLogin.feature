@loginModule
Feature: login Functionalities

  @LoginWithInvalidEmailIDOrPhone
  Scenario Outline: login with invalid email ID or phone number
    ##Given I navigate to url "https://www.amazon.in"
    Then I navigate to "Accounts and Lists" and hit "sigin" button
    Then I validate "Login" page
    Then I enter invalid <Email or mobile phone number>
    And I click "continue"
    Then I validate "header" <header>
    And I validate "error message" <error message>

    Examples: 
      | Email or mobile phone number | header                   | error message                                       |
      | "wqww22@yahoo.com"           | "There was a problem"    | "We cannot find an account with that email address" |
      | "443243"                     | "Incorrect phone number" | "We cannot find an account with that mobile number" |

  @LoginWithInvalidPassword
  Scenario Outline: login with invalid password
    #Given I navigate to url "https://www.amazon.in"
    Then I navigate to "Accounts and Lists" and hit "sigin" button
    Then I validate "Login" page
    Then I enter valid email id as "valid" in "phoneOrEmail"
    And I click "continue"
    And I enter invalid password <invalid password>
    And I click "login"
    Then I validate "header" <header>
    And I validate "error message" <error message>

    Examples: 
      | Email or mobile phone number | invalid password | header                | error message                |
      | " valid user name"           | "t5r477"         | "There was a problem" | "Your password is incorrect" |

  @loginWithValidCredentials
  Scenario: login with valid credentials
    #Given I loged in "https://www.amazon.in"
    Then I navigate to "Accounts and Lists" and hit "signIn" button
    Then I validate "Login" page
    Then I enter valid email id as "validUserName " in "phoneOrEmail"
    And I click "continue"
    And I enter valid password as "validpwrd" in "password" field
    And I click "login"
    Then I am landed on amazon home page and "Hello, king" is dispalyed
    And I log out from amazon
    Then I validate that i am successfully logged out
