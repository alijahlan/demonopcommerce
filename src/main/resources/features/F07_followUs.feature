@smoke
Feature: F07_followUs | User open social media links

  Scenario: user opens facebook link
    Given user click on facebook icon
    Then verify new tab link "https://www.facebook.com/nopCommerce"
    And close the current tab

  Scenario: user opens twitter link
    Given user click on twitter icon
    Then verify new tab link "https://twitter.com/nopCommerce"
    And close the current tab

  Scenario: user opens rss link
    Given user click on rss icon
    Then verify new tab link "https://demo.nopcommerce.com/new-online-store-is-open"
    And close the current tab

  Scenario: user opens youtube link
    Given user click on youtube icon
    Then verify new tab link "https://www.youtube.com/user/nopCommerce"
    And close the current tab