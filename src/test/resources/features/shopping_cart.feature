Feature: Shopping Cart
  As a customer
  I want to add and remove items from my shopping cart,
  So that I can review and purchase my selected items

  Scenario: Add item to the shopping cart
    Given the customer is viewing a product
    When the customer clicks on the "Add to Cart" button
    Then the item should be added to the shopping cart