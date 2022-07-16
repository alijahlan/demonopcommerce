@smoke
  Feature: F08_Wishlist | User using wish list to save a products
    Scenario: user save a products to the wish list
      Given user click on the heart icon
      Then verify the success msg "The product has been added to your wishlist" and BGColor "#4bb07a"

    Scenario: Check number of products added to the wish list
      Given user click on the heart icon
      When user close the success msg bar
      Then verify the wishlist Qty bigger than zero