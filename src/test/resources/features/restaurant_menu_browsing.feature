Feature:
  As a consumer,
  I want to browse restaurant menus on MTOGO,
  So that I can choose the food items I want to order.

  Scenario: View list of available restaurants
    Given the consumer is on the MTOGO platform
    When the consumer navigates to the restaurant page
    Then the consumer should see a list of available restaurants

