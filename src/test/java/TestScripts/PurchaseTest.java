package TestScripts;

import Generic_Utilities.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseClass { // Inherit from BaseClass!


    public void goToCheckout() throws InterruptedException {
        driver.findElement(By.linkText("14.1-inch Laptop")).click();
        driver.findElement(By.id("add-to-cart-button-31")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
    }

    @Test
    public void purchaseProductViaCOD() throws Exception {

        goToCheckout();

        driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
        Thread.sleep(1000);


        driver.findElement(By.id("paymentmethod_0")).click();
        driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();


    }

    @Test
    public void purchaseProductViaCC() throws Exception {

        goToCheckout();

        driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
        Thread.sleep(1000);


        driver.findElement(By.id("paymentmethod_2")).click();
        driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("CardholderName")).sendKeys("Manoj");
        driver.findElement(By.id("CardNumber")).sendKeys("1111222233334444");
        driver.findElement(By.id("CardCode")).sendKeys("231");

        driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
    }
}