package TestNG;

import Generic_Utilities.File_Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNG.Listeners_Implementations.class)
public class Listeners_Learning {
    public static  WebDriver driver;
    String email = File_Utility.getSingleData("Registration", 1, 3);
    String password = File_Utility.getSingleData("Registration", 1, 4);
        @Test
        public  void login() throws  Exception{
             driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get(File_Utility.getProperty("url"));
            Assert.assertEquals(driver.getTitle(),"Demnno Web Shop");
            driver.findElement(By.className("ico-login")).click();

            Assert.assertEquals(driver.getCurrentUrl().contains("login"),true);
            driver.findElement(By.id("Email")).clear();
            driver.findElement(By.id("Email")).sendKeys(email);

            driver.findElement(By.id("Password")).clear();
            driver.findElement(By.id("Password")).sendKeys(password);
            driver.findElement(By.xpath("//input[@value='Log in']")).click();

            WebElement logout = driver.findElement(By.linkText("Log out"));
            Assert.assertEquals(logout.isDisplayed(),true);
            Reporter.log("PASS --> USER LOOGED IN SUCCESFULLY . . .");

    }
}
