package dk.pejomi.mtogofrontendtest.bdd.definitions;

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

    WebDriver driver;
    String email = "mie@gmail.com";
    String password = "123";

    @Given("the consumer is on the MTOGO platform")
    public void theConsumerIsOnTheMTOGOPlatform() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
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
        driver.quit();
    }
}
