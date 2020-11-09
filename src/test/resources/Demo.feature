Feature: Demo feature



  Scenario: Demonstrating how Cucumber-JVM works
    Given Start Web Browser, URL: "https://www.saucedemo.com"
    When Enter Login "standard_user"
    When Enter Password "secret_sauce"
    When Click Login Button
    Then Check Correct Login
    When Add product "Sauce Labs Backpack" to basket shop
    Then Product "Sauce Labs Backpack" has Remove Button
    Then Basket Shop has Products
