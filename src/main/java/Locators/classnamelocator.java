package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class classnamelocator {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://github.com/");

        driver.findElement(By.className("x1i10hfl")).sendKeys("manojkiyan23032004@gmai.com");

        Thread.sleep(2000);

        driver.findElement(By.className("xggy1nq")).sendKeys("Manoj2316@");
    }
}
