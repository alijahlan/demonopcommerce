@smoke
Feature: F03_ChangeCurrency | user changes the currency and reflected on the products list
  Scenario: Select Euro currency from the dropdown list on the top left of home page
    Given select the currency type Euro Symbol
    Then verify Euro Symbol is shown on the products in Home page