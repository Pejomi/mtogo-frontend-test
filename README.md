# mtogo-frontend-test
by Jonas, Peter & Mie

## Introduction
This project works as the frontend-test part of the MTOGO-application project created by the group [Pejomi](). It is created to demonstrate frontend testing for the application. The related frontend are located in the [mtogo-frontend](https://github.com/Pejomi/mtogo-frontend.git) project.

For more information about the project see the [mtogo-microservices](https://github.com/Pejomi/mtogo-microservices.git) project.

## Description
The tests are written in the BDD style using Cucumber. The BDD style is a way of writing tests that focuses on the behavior of the system. The tests are written in a way that makes it easy for non-technical people to understand what the tests are doing.

### Feature files
The feature files are written in Gherkin. There are three feature files, one for each of the following features:
- Order Creation
- Restaurant menu browsing
- Restaurant search

Each feature file contains one scenario. Each scenario contains one or more steps. Each step is linked to a step definition.

Example of one of the feature file:
```gherkin
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
```
All the features and scenarios are located in the `src/test/resources/features` folder.

### Step definitions
There is one step definition for each step in the feature files. Each step definition contains the code that should be executed when the step is run.

Example of a step definition:
```java
@Given("the consumer has logged in")
public void theConsumerHasLoggedIn() {
    // Code to log in the consumer
}
...
@When("the consumer reviews list of items in the cart")
public void theConsumerReviewsListOfItemsInTheCart() {
    // Code to review the items in the cart
}
...
@Then("the consumer should see the message {string}")
public void theConsumerShouldSeeTheMessage(String message) {
    // Code to verify that the message is displayed
}
```
All the step definitions are located in the `src/test/java/dk/pejomi/mtogofrontendtest/bdd/definitions` folder.

### Technologies
This project is created with:
- [Java](https://www.java.com/en/)
- [Cucumber](https://cucumber.io/)
- [Gherkin](https://cucumber.io/docs/gherkin/)
- [Selenium Java](https://www.selenium.dev/documentation/en/selenium_installation/installing_selenium_libraries/)
- [Selenium ChromeDriver](https://chromedriver.chromium.org/getting-started)

## Getting Started
To get started, you should first get this file in your local machine by running the following command:

```bash
git clone https://github.com/Pejomi/mtogo-frontend-test.git
```
To ensure that you can run the tests you also need the mtogo-frontend project. See the instructions [here](https://github.com/Pejomi/mtogo-frontend.git).

### Running the tests
To run all test scenarios, run the class `src/test/java/dk/pejomi/mtogofrontendtest/bdd/RunCucumberTest.java`.

To run a specific scenario, find the scenario in one of the feature-files in the `src/test/resources/features` folder and run the scenario.