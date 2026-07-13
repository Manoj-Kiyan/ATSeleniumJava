package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvocationAndParllelExecution {

    @Test(invocationCount = 5,threadPoolSize = 2)
    public void loginTest(){

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");

        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("gender-male")).click();


        driver.findElement(By.id("FirstName")).sendKeys("Manoj");

        driver.findElement(By.id("LastName")).sendKeys("Kiyan");

        driver.findElement(By.id("Email")).sendKeys("mk@gmail.com");

        driver.findElement(By.id("Password")).sendKeys("Manoj2316");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Manoj2316");

        driver.findElement(By.id("register-button")).click();



        driver.findElement(By.linkText("Log in")).click();

        driver.findElement(By.id("Email")).sendKeys("mk@gmail.com");

        driver.findElement(By.id("Password")).sendKeys("Manoj2316");

        driver.findElement(By.xpath("//input[@value = 'Log in']")).click();

        driver.quit();

    }
}
