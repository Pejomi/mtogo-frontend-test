Feature: Order Creation
  As a consumer
  I want to create an order
  So that I can get food from a restaurant

  Scenario: Review and confirm the order
    Given the consumer has logged in
    And added items to the cart by clicking the "Add to cart" button
    When the consumer reviews list of items in the cart
    And creates the order by clicking the "Create order" button
    Then the consumer should see the message "Order successfully created!"