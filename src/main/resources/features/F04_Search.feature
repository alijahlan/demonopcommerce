@smoke
Feature: F04_Search | Logged User could search for any product

  Scenario Outline: user could search using product name
    Given user enter "<product_name>" in search field
    When user click on search button
    Then verify the URl contains "<product_name>"
    And verify results contains "<product_name>"
    Examples:
      | product_name |
      | book         |
      | laptop       |
      | nike         |


  Scenario Outline: user could search using sku
    Given user enter "<product_sku>" in search field
    When user click on search button
    And user click on the product card
    And verify product sku contains "<product_sku>"
    Examples:
      | product_sku |
      | SCI_FAITH   |
      | APPLE_CAM   |
      | SF_PRO_11   |