package dk.pejomi.mtogofrontendtest.bdd.definitions;

import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderCreationDefinitions {
    final String URL = "http://localhost:3000";
    static WebDriver driver;
    String email = "test@gmail.com";
    String password = "test";
    String expectedCartSize = "2";

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
//        driver.get(URL + "/create_account");
//        driver.findElement(By.id("email")).sendKeys(email);
//        driver.findElement(By.id("password")).sendKeys(password);
//        driver.findElement(By.id("phone")).sendKeys(phone);
//        driver.findElement(By.id("street")).sendKeys(street);
//        driver.findElement(By.id("city")).sendKeys(city);
//        driver.findElement(By.id("zipcode")).sendKeys(zipCode);
//        driver.findElement(By.id("country")).sendKeys(country);
//        WebElement submitButton = driver.findElement(By.id("submit-create-account"));
    }

    @AfterAll
    public static void tearDown() {
        // delete account
        driver.quit();
    }

    @Given("the consumer has logged in")
    public void theConsumerHasLoggedIn() {
        driver.get(URL + "/login");
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        WebElement submitButton = driver.findElement(By.id("submit-login"));
        submitButton.click();
        WebElement emailElement = driver.findElement(By.id("user-email"));
        assertEquals(email, emailElement.getText());
    }

    @And("added items to the cart by clicking the {string} button")
    public void addedItemsToTheOrder(String arg0) {
        driver.get(URL + "/restaurants/1");
        WebElement buttonElement = driver.findElements(By.xpath("//*[text()='"+ arg0 +"']")).get(0);
        buttonElement.click();
        buttonElement.click();
        String cartSize = driver.findElement(By.id("cart-size")).getText();
        assertEquals("2", cartSize);
    }

    @When("the consumer reviews list of items in the cart")
    public void theConsumerReviewsTheOrder() {
        WebElement buttonElement = driver.findElement(By.id("cart"));
        buttonElement.click();
        WebElement cartList = driver.findElement(By.id("cart-list"));
        assertTrue(cartList.isDisplayed());
    }

    @And("creates the order by clicking the {string} button")
    public void confirmsTheOrder(String arg0) {
        WebElement buttonElement =  driver.findElement(By.xpath("//*[text()='"+ arg0 +"']"));
        buttonElement.click();
    }

    @Then("the consumer should see the message {string}")
    public void theOrderShouldBeSubmittedToTheRestaurantForProcessing(String arg0) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        WebElement resultElement = driver.findElement(By.xpath("//*[text()='"+ arg0 +"']"));
        assertTrue(resultElement.isDisplayed());
    }
}
