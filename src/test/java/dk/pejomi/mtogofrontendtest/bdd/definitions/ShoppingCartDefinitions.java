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

public class ShoppingCartDefinitions {

    WebDriver driver;
    String email = "test@gmail.com";
    String password = "test";
    String expectedCartSize = "1";

    @Given("the customer is logged in")
    public void theCustomerIsLoggedIn() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("http://localhost:3000/login");
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        WebElement submitButton = driver.findElement(By.id("submit-login"));
        submitButton.click();
        WebElement emailElement = driver.findElement(By.id("user-email"));
        assertEquals(email, emailElement.getText());
    }

    @And("is viewing a product")
    public void isViewingAProduct() {
        driver.get("http://localhost:3000/restaurants/1");
    }

    @When("the customer clicks on the {string} button")
    public void theCustomerClicksOnTheButton(String arg0) {
        WebElement buttonElement = driver.findElements(By.xpath("//*[text()='"+ arg0 +"']")).get(0);
        buttonElement.click();
    }

    @Then("the item should be added to the shopping cart")
    public void theItemShouldBeAddedToTheShoppingCart() {
        String cartSize = driver.findElement(By.id("cart-size")).getText();
        driver.quit();
        assertEquals(expectedCartSize, cartSize);
    }
}
