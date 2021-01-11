Feature: Remove scenario
  Test checking the functions of removing products from the cart

  Scenario: Remove product from basket
    Given Open the page "https://www.saucedemo.com" on the basket with one product added
    When Click remove button
    Then Check if the basket is empty