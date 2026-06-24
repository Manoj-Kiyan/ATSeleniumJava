package SwitchToMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AmazonTask {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile", Keys.ENTER);

        Thread.sleep(3000);

        String parentWindow = driver.getWindowHandle();

        List<WebElement> mobiles = driver.findElements(By.xpath("//a[contains(@class,'a-link-normal s-line-clamp-2')]"));

        for (int i = 0; i < Math.min(mobiles.size(), 10); i++) {

            // Re-fetch elements
            mobiles = driver.findElements(By.xpath("//a[contains(@class,'a-link-normal s-line-clamp-2')]"));

            String productUrl = mobiles.get(i).getAttribute("href");

            System.out.println("\nOpening Product : " + (i + 1));

            // Create New Tab
            driver.switchTo().newWindow(WindowType.TAB);

            // Open Product URL
            driver.get(productUrl);

            Thread.sleep(2000);

            try {

                String title = driver.findElement(By.id("productTitle")).getText();

                System.out.println("Checking : " + title);

                if (title.toLowerCase().contains("iqoo")) {

                    System.out.println("***** IQOO FOUND *****");

                    try {

                        String price = driver.findElement(By.cssSelector(".a-price-whole")).getText();

                        System.out.println("Price : ₹" + price);

                    } catch (Exception e) {

                        System.out.println("Price Not Found");
                    }

                    // KEEP IQOO TAB OPEN
                    driver.switchTo().window(parentWindow);
                }
                else {

                    System.out.println("Not IQOO -> Closing Tab");

                    driver.close();

                    driver.switchTo().window(parentWindow);
                }

            } catch (Exception e) {

                System.out.println("Product Title Not Found");

                driver.close();

                driver.switchTo().window(parentWindow);
            }
        }

        System.out.println("\nTask Completed");
    }
}