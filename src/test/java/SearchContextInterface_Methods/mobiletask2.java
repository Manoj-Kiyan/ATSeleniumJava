package SearchContextInterface_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class mobiletask2 {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.flipkart.com");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[@role='button']")).click();

        driver.findElement(
                By.xpath("//input[@title='Search for Products, Brands and More']")
        ).sendKeys("Mobiles");

        driver.findElement(
                By.xpath("//button[@type='submit']")
        ).click();

        Thread.sleep(5000);

        // Fetch All Mobile Names
        List<WebElement> mobileNames =
                driver.findElements(By.xpath("//div[@class='RG5Slk']"));

        for (WebElement mobileName : mobileNames) {

            String name = mobileName.getText();

            System.out.println("=================================");
            System.out.println("Mobile Name : " + name);

            // Current Product Card
            WebElement card = mobileName.findElement(
                    By.xpath("./ancestor::div[contains(@class,'row')]")
            );

            // Price
            try {

                WebElement mobilePrice = card.findElement(
                        By.xpath(".//div[contains(@class,'DeU9vF')]")
                );

                System.out.println("Price : " + mobilePrice.getText());

            } catch (Exception e) {

                System.out.println("Price : Not Available");
            }

            // Discount
            try {

                WebElement discount = card.findElement(
                        By.xpath(".//div[contains(@class,'HQe8jr')]//span")
                );

                System.out.println("Discount : " + discount.getText());

            } catch (Exception e) {

                System.out.println("Discount : Not Available");
            }

            // MRP
            try {

                WebElement mrp = card.findElement(
                        By.xpath(".//div[contains(@class,'gxR4EY')]")
                );

                System.out.println("MRP : " + mrp.getText());

            } catch (Exception e) {

                System.out.println("MRP : Not Available");
            }

            System.out.println();
        }

        driver.quit();
    }
}