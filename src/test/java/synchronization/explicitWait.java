package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class explicitWait {
    public static void main(String[] args) throws  Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.textToBe(By.className("ico-register"),"Register"));

        driver.findElement(By.className("ico-register")).click();

        driver.findElement(By.id("gender-male")).click();
        wait.until(ExpectedConditions.elementToBeSelected(By.id("gender-male")));



        driver.findElement(By.id("FirstName")).sendKeys("Manoj");
        wait.until(ExpectedConditions.textToBe(By.id("FirstName"),"Manoj"));

        driver.findElement(By.id("LastName")).sendKeys("Kiyan");
        wait.until(ExpectedConditions.attributeContains(By.id("LastName"),"value","Kiyan"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        driver.findElement(By.id("Email")).sendKeys("mk@gmail.com");


        driver.findElement(By.name("Password")).sendKeys("MKiyan2316@");
        Boolean password = wait.until(ExpectedConditions.textToBe(By.name("Password"), "MKiyan2316@"));
        String pass = password.toString();
        System.out.println(pass);

        driver.findElement(By.name("ConfirmPassword")).sendKeys("MKiyan2316@");



    }
}
