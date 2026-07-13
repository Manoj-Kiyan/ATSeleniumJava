package Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.flipkart.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("8148002316");

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

       driver.findElement(By.className("WHahJn")).click();

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div/div/header/div[1]/div[1]/form/div/div/input")).sendKeys("Latest mobiles");

       driver.findElement(By.className("nw1UBF")).click();
    }

}


//If email field not loaded:
//
//Selenium retry pannum
//max 10 sec
//
//Found aana:
// ✅ continue immediately
//
//Advantages ✅
//✔ simple
//✔ easy
//✔ global wait
//✔ less code
//Disadvantages ❌
//❌ all elements-ku same wait
//❌ not flexible
//❌ dynamic apps-ku enough illa