@smoke
  Feature: F05_hoverCategories | Ensure that products appear in categories
    Scenario: User hover on one of main categories then click on sub category
      Given User hover on random main category on the top menu
      When user click on a sub category of product
      Then verify if the category title is matching