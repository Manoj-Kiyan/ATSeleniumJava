package Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class thread {
    //Java wait , not selenium wait
    public static void main(String[] args)
            throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

        driver.manage().window().maximize();

        // wait 5 seconds
        Thread.sleep(5000);

        driver.findElement(By.id("email")).sendKeys("admin");
    }
}
//Other Problems
//
//❌ slow execution
//❌ unnecessary waiting
//❌ bad practice
//❌ not dynamic