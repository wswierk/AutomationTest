Feature: Demo feature



  Scenario: Demonstrating how Cucumber-JVM works
    Given Start Web Browser, URL: "https://www.saucedemo.com"
    When Enter Login "standard_user"
    When Enter Password "secret_sauce"
    When Click Login Button
    Then Check Correct Login

