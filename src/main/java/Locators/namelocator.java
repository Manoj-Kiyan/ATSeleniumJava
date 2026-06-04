package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class namelocator {

    public static void main(String[] args) throws  Exception{

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.instagram.com");

        Thread.sleep(2000);

        driver.findElement(By.name("email")).sendKeys("manojkiyan23032004@gmail.com");

        Thread.sleep(2000);

        driver.findElement(By.name("pass")).sendKeys("Manoj2316@");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div/div[1]/div/div[3]/div/div/div")).click();

    }
}
