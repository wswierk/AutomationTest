Feature: End to End test
  Basic program path test.
  Checking the operation from user login to product purchase.

  Scenario: Product purchase
    Given Start web browser, URL: "https://www.saucedemo.com"
    When Enter login "standard_user"
    When Enter password "secret_sauce"
    When Click login button
    Then Check correct login
    When Add product "Sauce Labs Backpack" to basket shop
    Then Product "Sauce Labs Backpack" has remove button
    Then Basket shop has products
    When Click basket shop
    Then Basket page is displayed
    Then Product "Sauce Labs Backpack" is in basket
    When Click checkout button
    Then Order page is displayed
    When Input first name "Name"
    When Input last name "Surname"
    When Input postal code "12-345"
    Then Click continue button
    Then Checkout order page is displayed
    Then Product "Sauce Labs Backpack" is on order list
    Then Payment information is "SauceCard #31337"
    Then Shipping information is "FREE PONY EXPRESS DELIVERY!"
    Then Item total cost is "$29.99"
    Then Tax cost is "$2.40"
    Then Total cost is "$32.39"
    When Click finish button
    Then Checkout complete page is displayed