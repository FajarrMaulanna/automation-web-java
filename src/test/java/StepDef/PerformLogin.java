package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PerformLogin {
    WebDriver driver;
    @Given("I Open browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @And("Open website Swag Labs")
    public void openWebsiteSwagLabs() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @When("Input Valid Username")
    public void inputValidUsername() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    }

    @Then("Showing Page Dashboard")
    public void showingPageDashboard() {
        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(title, "Products");
        driver.close();
}

    @When("Input Invalid Username")
    public void inputInvalidUsername() {
        driver.findElement(By.name("user-name")).sendKeys("user");
    }

    @Then("Showing Error Message")
    public void showingErrorMessage() {
        String error_message = driver.findElement(By.cssSelector("h3")).getText();
        Assert.assertEquals(error_message, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

    @When("Add Product to Chart")
    public void addProductToChart() {
        driver.findElement(By.id("item_4_title_link")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("Product has been Added")
    public void productHasBeenAdded() {
        String button_status = driver.findElement(By.id("remove-sauce-labs-backpack")).getText();
        Assert.assertEquals(button_status, "Remove");
        driver.close();
    }

    @And("Checkout Product from Chart")
    public void checkoutProductFromChart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
    }

    @Then("Product has been checkout")
    public void productHasBeenCheckout() {
        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(title, "Checkout: Your Information");
        driver.close();
    }
}
