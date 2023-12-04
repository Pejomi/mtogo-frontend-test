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

public class ShoppingCartDefinitions {
    static final String URL = "http://localhost:3000";
    static WebDriver driver;
    static String email = "test@gmail.com";
    static String password = "test";
    static String phone = "12345678";
    static String street = "Test Street 1";
    static String city = "Test City";
    static String zipCode = "1234";
    static String country = "Denmark";
    String expectedCartSize = "1";

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

    @Given("the consumer is logged in")
    public void theCustomerIsLoggedIn() {
        driver.get(URL + "/login");
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        WebElement submitButton = driver.findElement(By.id("submit-login"));
        submitButton.click();
        WebElement emailElement = driver.findElement(By.id("user-email"));
        assertEquals(email, emailElement.getText());
    }

    @And("is viewing a product")
    public void isViewingAProduct() {
        driver.get(URL + "/restaurants/1");
    }

    @When("the consumer clicks on the {string} button")
    public void theCustomerClicksOnTheButton(String arg0) {
        WebElement buttonElement = driver.findElements(By.xpath("//*[text()='"+ arg0 +"']")).get(0);
        buttonElement.click();
    }

    @Then("the item should be added to the shopping cart")
    public void theItemShouldBeAddedToTheShoppingCart() {
        String cartSize = driver.findElement(By.id("cart-size")).getText();
        assertEquals(expectedCartSize, cartSize);
    }
}
