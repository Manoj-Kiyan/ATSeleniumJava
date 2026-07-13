package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDrivenTestingFromXmlFile {

    @Parameters({"Url","FirstName","LastName","Email","Password","ConfirmPassword"})
    @Test
    public  void loginTest(String Url,String FirstName,String LastName,String Email,String Password,String ConfirmPassword){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(Url);

        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("gender-male")).click();


        driver.findElement(By.id("FirstName")).sendKeys(FirstName) ;

        driver.findElement(By.id("LastName")).sendKeys(LastName) ;

        driver.findElement(By.id("Email")).sendKeys(Email);

        driver.findElement(By.id("Password")).sendKeys(Password) ;
        driver.findElement(By.id("ConfirmPassword")).sendKeys(ConfirmPassword);

        driver.findElement(By.id("register-button")).click() ;


        driver.findElement(By.linkText("Log in")).click();

        driver.findElement(By.id("Email")).sendKeys(Email);

        driver.findElement(By.id("Password")).sendKeys(Password);

        driver.findElement(By.xpath("//input[@value = 'Log in']")).click();

        driver.quit();
    }
}
