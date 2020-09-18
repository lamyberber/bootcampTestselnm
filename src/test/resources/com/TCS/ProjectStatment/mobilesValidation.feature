@mobile
Feature: Add Mobile item to amazon cart and change the the delivery location

  @fuctionalTest
  Scenario: amazon
   # Given I am navigated "https://www.amazon.in"
    And I enter "mi mobile" in the "search bar" textBox
    And I click on "search button"
    Then I validate the search Results as "number of pages" Results for "mi mobile"
    And I  Select Avg. Customer Review as "4 stars& Up"
    And I select "the first item" that appears
    Then I Validate the appeared mobile is relevant to the first item selected
    And I validate the price of "first item selected"
    Then I click on "delivery location"
    And I validate the "Choose your location" model
    And I enter "500011" in the "picode" textBox
    And I click on "apply button"
    Then I Validate the change in the delivery location as Deliver to "Secunderabad 500011‌"
   Then I click on "Sponsored link" on the page
    And I click on "Add to cart"
    Then I validate "Added to Cart" message is dispalyed
    And I Close the "Added to Cart window"
    And I scroll downwards until "Technical Details"
