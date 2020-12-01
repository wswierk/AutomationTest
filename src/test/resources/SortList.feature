Feature: Check sort list

  Scenario: Validate the sort list
    Given Start web browser on home page, URL: "https://www.saucedemo.com"
    When Set sort list by "Name (A to Z)"
    Then Check correct sort
    When Set sort list by "Name (Z to A)"
    Then Check correct sort
    When Set sort list by "Price (low to high)"
    Then Check correct sort
    When Set sort list by "Price (high to low)"
    Then Check correct sort