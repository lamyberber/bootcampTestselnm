@UrlValidation
Feature: check the url and get the title

  @urlNavigation
  Scenario: url
    Given I enter url as "http://amzn.in"
    Then I redirected to "https://www.amazon.in/"
    And I vaidate the page title as "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
