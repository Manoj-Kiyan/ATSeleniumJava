package TestScripts;

import Generic_Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class PurchaseTest extends BaseClass { // Inherit from BaseClass!


    public void goToCheckout() throws InterruptedException {
        driver.findElement(By.linkText("14.1-inch Laptop")).click();
        driver.findElement(By.id("add-to-cart-button-31")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
    }

    @Test(groups = {"Smoke","Functional"})
    public void purchaseProductViaCOD() throws Exception {

        goToCheckout();
        WebElement dropDownAddress=driver.findElement(By.id("billing-address-select"));
        Select addAddress = new Select(dropDownAddress);
        addAddress.selectByVisibleText("New Address");

        List<WebElement> address=driver.findElements(By.xpath("//div[@class='edit-address']/descendant::div[@class='inputs']"));

        for(WebElement element:address){
            String id = element.getAttribute("id");
            if(id.equals("BillingNewAddress_FirstName")){
                element.clear();
                element.sendKeys("Manoj");
            } else if (id.equals("BillingNewAddress_LastName")) {
                element.clear();
                element.sendKeys("M");
            } else if (id.equals("BillingNewAddress_Email")) {
                element.clear();
                element.sendKeys("mk2316@gmail.com");
            } else if (id.equals("BillingNewAddress.Company")) {
                continue;
            } else if (id.equals("")) {
                
            }
        }

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