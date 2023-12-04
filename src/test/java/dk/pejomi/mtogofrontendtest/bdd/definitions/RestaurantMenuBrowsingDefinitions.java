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

public class RestaurantMenuBrowsingDefinitions {

    static WebDriver driver;
    String email = "test@gmail.com";
    String password = "test";

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

    @Given("the consumer is on the MTOGO platform")
    public void theConsumerIsOnTheMTOGOPlatform() {
        driver.get("http://localhost:3000");
    }

    @And("logs in")
    public void logsIn() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        WebElement navigationButtonElement = driver.findElements(By.xpath("//*[text()='Login']")).get(0);
        navigationButtonElement.click();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        WebElement submitButton = driver.findElement(By.id("submit-login"));
        submitButton.click();
        WebElement emailElement = driver.findElement(By.id("user-email"));
        assertEquals(email, emailElement.getText());
    }

    @When("the consumer navigates to the {string} page")
    public void theConsumerNavigatesToThePage(String arg0) {
        WebElement buttonElement = driver.findElements(By.xpath("//*[text()='"+ arg0 +"']")).get(0);
        buttonElement.click();
    }

    @Then("the consumer should see a list of available restaurants")
    public void theConsumerShouldSeeAListOfAvailableRestaurants() {
        WebElement restaurantList = driver.findElement(By.id("restaurant-list"));
        assertTrue(restaurantList.isDisplayed());
    }
}
