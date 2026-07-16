package TestNG;

import Generic_Utilities.File_Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Assert_Practice {

    @Test
    public void loginTestSoftAssert() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(File_Utility.getProperty("url"));

        SoftAssert ast = new SoftAssert();

        String Email = File_Utility.getSingleData("Registration",1,3);
        String Password = File_Utility.getSingleData("Registration",1,4);

        ast.assertEquals(driver.getTitle(),"mo0000 Web Shop","Welcome Page Not Displayed");
            //if(driver.getTitle().equals("Demo Web Shop")){
            System.out.println("Welcome Page Displayed Successfully");

            driver.findElement(By.className("ico-login")).click();

        ast.assertEquals(driver.getCurrentUrl().contains("login"),true,"Login Page Not Display");
            // if(driver.getCurrentUrl().contains("login")) {
            System.out.println("LOGIN PAGE DISPALY SUCCESFULLY . . .");
            driver.findElement(By.id("Email")).sendKeys(Email);

            driver.findElement(By.id("Password")).sendKeys(Password);

            driver.findElement(By.id("RememberMe")).click();

            driver.findElement(By.xpath("//input[@value='Log in']")).click();

            WebElement account = driver.findElement(By.xpath("//div[@class='header']//descendant::div[@class='header-links']//descendant::a[@class='account']"));

        ast.assertEquals(account.getText(),Email,"ERROR : MIS-MATCH EMAIL ");
            //if(account.getText().equals(Email))
            System.out.println("CORRECT ACCOUNT LOG IN SUCCESFULLY . . .");
            //else
            // System.out.println("ERROR : MIS-MATCH EMAIL ");

            // }else {
            //System.out.println("ERROR MESSSAGE DISPLAY . . .");
            //driver.quit();
            //}
            // }else {
            //System.out.println("ERROR MESSSAGE DISPLAY . . .");
        ast.assertAll();
        driver.quit();
        //}
    }
}
