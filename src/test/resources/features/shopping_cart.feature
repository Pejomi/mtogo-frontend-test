Feature: Shopping Cart
  As a customer,
  I want to add and remove items from my shopping cart,
  So that I can review and purchase my selected items.

  Scenario: Add item to the shopping cart
    Given the consumer is logged in
    And is viewing a product
    When the consumer clicks on the "Add to cart" button
    Then the item should be added to the shopping cart