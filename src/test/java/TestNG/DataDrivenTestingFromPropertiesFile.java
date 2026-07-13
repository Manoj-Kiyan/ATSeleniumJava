package TestNG;

import com.google.j2objc.annotations.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class DataDrivenTestingFromPropertiesFile   {
        @Test
        public void  login() throws IOException {

                FileInputStream input = new FileInputStream("./src/main/resources/common.properties");

                Properties property = new Properties();
                property.load(input);

                String URL = property.getProperty("url");
                String EMAIL = property.getProperty("email");
                String PASS = property.getProperty("password");
                String FIRSTNAME = property.getProperty("firstname");
                String LASTNAME = property.getProperty("lastname");

                WebDriver driver = new ChromeDriver();

                driver.manage().window().maximize();

                driver.get(URL);

                driver.findElement(By.linkText("Register")).click();

                driver.findElement(By.id("gender-male")).click();


                driver.findElement(By.id("FirstName")).sendKeys(FIRSTNAME) ;

                driver.findElement(By.id("LastName")).sendKeys(LASTNAME) ;

                driver.findElement(By.id("Email")).sendKeys(EMAIL);

                driver.findElement(By.id("Password")).sendKeys(PASS) ;
                driver.findElement(By.id("ConfirmPassword")).sendKeys(PASS);

                driver.findElement(By.id("register-button")).click() ;


                driver.findElement(By.linkText("Log in")).click();

                driver.findElement(By.id("Email")).sendKeys(EMAIL);

                driver.findElement(By.id("Password")).sendKeys(PASS);

                driver.findElement(By.xpath("//input[@value = 'Log in']")).click();

                driver.quit();
        }
    }

