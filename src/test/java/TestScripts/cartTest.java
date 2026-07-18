package TestScripts;

import Generic_Utilities.BaseClass;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class cartTest extends BaseClass {

    @Test(priority = 1)
    public void addToCartTest() throws Exception {

        driver.findElement(By.linkText("14.1-inch Laptop")).click();
        driver.findElement(By.id("add-to-cart-button-31")).click();
        Thread.sleep(2000);
        Reporter.log("PRODUCT ADDED TO CART SUCCESSFULLY . . .",true);
    }

    @Test(priority = 2)
    public void updateProductCountTest() throws InterruptedException {
        driver.findElement(By.linkText("14.1-inch Laptop")).click();
        driver.findElement(By.id("add-to-cart-button-31")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();

        driver.findElement(By.xpath("//input[contains(@name, 'itemquantity')]")).clear();
        driver.findElement(By.xpath("//input[contains(@name, 'itemquantity')]")).sendKeys("3");
        driver.findElement(By.name("updatecart")).click();
        Reporter.log("PRODUCT UPDATED FROM CART SUCCESSFULLY . . .",true);
    }

    @Test(priority = 3)
    public void removeFromCartTest() throws InterruptedException {
        driver.findElement(By.linkText("14.1-inch Laptop")).click();
        driver.findElement(By.id("add-to-cart-button-31")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();

        driver.findElement(By.name("removefromcart")).click();
        driver.findElement(By.name("updatecart")).click();

        Reporter.log("PRODUCT REMOVED FROM CART SUCCESSFULLY . . .",true);
    }
}