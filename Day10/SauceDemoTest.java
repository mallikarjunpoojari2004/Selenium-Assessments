package AssessmentDay10;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
public class SauceDemoTest {
    WebDriver driver;
    pomLoginpage login;
    ProductsPage products;
    CartPage cart;
    CheckoutPage checkout;

    // =========================
    // BEFORE CLASS
    // =========================
    @BeforeClass
    public void setup() throws IOException {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(PropertyUtility.getData("url"));
        // Create POM objects
        login = new pomLoginpage(driver);
        products = new ProductsPage(driver);
        cart = new CartPage(driver);
        checkout = new CheckoutPage(driver);
        System.out.println("Browser launched");
    }
    // =========================
    // TEST CASE 1 - LOGIN
    // =========================

    @Test
    public void loginTest() throws IOException, InterruptedException {
        // Login using property file data
        login.getUser(PropertyUtility.getData("username"));
        login.getPass(PropertyUtility.getData("password"));
        login.getLoginBtn();
        Thread.sleep(2000);

        // Verify Products page
        if (products.isProdDisplayed()) {
            System.out.println("Login successful");
            System.out.println("Products page is displayed");
        } else {
            System.out.println("Products page is NOT displayed");
        }
        //Note:Instead of if-else use Assert methods
//        Assert.assertTrue(products.isProdDisplayed(), "Products page is NOT displayed");
//        System.out.println("Login successful");
//        System.out.println("Products page is displayed");
    }

    // =========================
    // TEST CASE 2 - ORDER PLACEMENT
    // =========================
    @Test(dependsOnMethods = "loginTest")
    public void oderPalcementTest() throws IOException, InterruptedException {
        // Add Sauce Labs Backpack
        products.addBackPack();
        System.out.println("Sauce Labs Backpack added to cart");

        // Verify cart contains 1 item
        if (products.getCartCount().equals("1")) {
            System.out.println("Cart contains 1 item");
        } else {
            System.out.println("Cart does not contain 1 item");
        }

        // Open cart
        products.getCartBtn();
        Thread.sleep(2000);

        // Verify Backpack is displayed
        if (cart.isBackpackDisplayed()) {
            System.out.println("Sauce Labs Backpack is displayed in cart");
        } else {
            System.out.println("Sauce Labs Backpack is NOT displayed in cart");
        }

        // Click Checkout
        cart.getCheckOut();
        Thread.sleep(2000);

        // Read test data from Excel
        String firstName = ExcelUtility.getData(1, 0);
        String lastName = ExcelUtility.getData(1, 1);
        String postalCode = ExcelUtility.getData(1, 2);

        // Enter First Name
        checkout.getFirstName(firstName);

        // Enter Last Name
        checkout.getlastName(lastName);

        // Enter Postal Code
        checkout.getZip(postalCode);

        // Click Continue
        checkout.getContinue();
        Thread.sleep(2000);

        // Verify Checkout Overview page
        if (checkout.isCheckoutOverviewDisplayed()) {
            System.out.println("Checkout: Overview page is displayed");
        } else {
            System.out.println("Checkout: Overview page is NOT displayed");
        }

        // Click Finish
        checkout.getFinish();

        // Verify Thank You message
        if (checkout.getSuccessMessage().equals("Thank you for your order!")) {
            System.out.println("Thank you for your order!");
        } else {
            System.out.println("Order confirmation message is NOT displayed");
        }
    }

    // =========================
    // AFTER CLASS
    // =========================
    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Browser closed");
    }
}