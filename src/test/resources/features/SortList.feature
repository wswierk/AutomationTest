Feature: Check sort list

  Scenario Outline: Validate the sort list by <Sort By>
    Given Start web browser on home page, URL: "https://www.saucedemo.com"
    When Set sort list by <Sort By>
    Then Check correct sort

    Examples: Sort by
    | Sort By |
    | "Name (A to Z)" |
    | "Name (Z to A)" |
    | "Price (low to high)" |
    | "Price (high to low)" |