package TestScripts;

import Generic_Utilities.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class wishListTest extends BaseClass {

    @Test(priority = 1)
    public void addToWishlistTest() throws InterruptedException {

        driver.findElement(By.partialLinkText("Books")).click();
        driver.findElement(By.linkText("Fiction EX")).click();
        driver.findElement(By.id("add-to-wishlist-button-78")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void updateProductCountTest() throws InterruptedException {

        driver.findElement(By.partialLinkText("Books")).click();
        driver.findElement(By.linkText("Fiction EX")).click();
        driver.findElement(By.id("add-to-wishlist-button-78")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Wishlist']")).click();

        driver.findElement(By.xpath("//input[contains(@name, 'itemquantity')]")).clear();
        driver.findElement(By.xpath("//input[contains(@name, 'itemquantity')]")).sendKeys("5");
        driver.findElement(By.name("updatecart")).click();
    }

    @Test(priority = 3)
    public void removeFromWishlistTest() throws InterruptedException {

        driver.findElement(By.partialLinkText("Books")).click();
        driver.findElement(By.linkText("Fiction EX")).click();
        driver.findElement(By.id("add-to-wishlist-button-78")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Wishlist']")).click();

        driver.findElement(By.name("removefromcart")).click();
        driver.findElement(By.name("updatecart")).click();
    }

    @Test(priority = 4)
    public void addToCartFromWishlistTest() throws InterruptedException {

        driver.findElement(By.partialLinkText("Books")).click();
        driver.findElement(By.linkText("Fiction EX")).click();
        driver.findElement(By.id("add-to-wishlist-button-78")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Wishlist']")).click();

        driver.findElement(By.name("addtocart")).click();
        driver.findElement(By.name("addtocartbutton")).click();
    }
}