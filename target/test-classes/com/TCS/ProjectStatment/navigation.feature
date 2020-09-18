@Navigation
Feature: Navigation to diferent amazon modules

  @NavigationTest1
  Scenario Outline: amazon module Navigation
    Given I navigate to <tab> and to <module>
    Then I validate the <page> page

    Examples: 
      | tab                  | module             | page                 |
      | "Accounts and Lists" | "Create Wish List" | "wishlist"           |
      | "Accounts and Lists" | "Your Account"     | "Amazon Pay balance" |
 
 @NavigationTest2
  Scenario: amazon module Navigation
    Given I navigate to "New Releases"
    Then I validate the "new Releases Page" page
    