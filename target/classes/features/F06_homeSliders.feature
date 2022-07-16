@smoke
  Feature: F06_homeSliders | check if the home slider is work as expected
    Scenario: verify if the first slider link is exist
      Given user click first slide
      Then verify if the redirect link is "https://demo.nopcommerce.com/nokia-lumia-1020"

    Scenario: verify if the second slider link is exist
      Given user click second slide
      Then verify if the redirect link is "https://demo.nopcommerce.com/iphone-6"


