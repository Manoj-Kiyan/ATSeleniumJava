package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class linkText {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        // enter email
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");

        // enter password
        driver.findElement(By.name("pass")).sendKeys("mypassword");

        // click forgotten password link
        driver.findElement(By.linkText("Forgotten password?")).click();
    }
}
