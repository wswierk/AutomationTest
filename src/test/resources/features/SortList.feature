Feature: Check sort list


  Scenario: Validate the sort list by name (A to Z)
    Given Start web browser on home page, URL: "https://www.saucedemo.com"
    When Set sort list by name (A to Z)
    Then Validate the sort

  Scenario: Validate the sort list by name (Z to A)
    Given Start web browser on home page, URL: "https://www.saucedemo.com"
    When Set sort list by name (Z to A)
    Then Validate the sort

  Scenario: Validate the sort list by price (low to high)
    Given Start web browser on home page, URL: "https://www.saucedemo.com"
    When Set sort list by price (low to high)
    Then Validate the sort

  Scenario: Validate the sort list by price (high to low)
    Given Start web browser on home page, URL: "https://www.saucedemo.com"
    When Set sort list by price (high to low)
    Then Validate the sort