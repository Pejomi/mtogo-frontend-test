Feature: Order Creation
  As a consumer
  I want to create an order
  So that I can get food from a restaurant

  Scenario: Review and confirm the order
    Given the consumer has logged in
    And added items to the order
    And has provided delivery or pickup details
    When the consumer reviews the order
    And confirms the order
    Then the order should be submitted to the restaurant for processing