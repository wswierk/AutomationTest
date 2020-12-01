Feature: Remove scenario


  Scenario: Remove product
    Given Remove product from basket shop "https://www.saucedemo.com"
    When Click remove button
    Then Check if the basket is empty