package TestNG;

import Generic_Utilities.File_Utility;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DataDrivenTestingFromExcelMultipleData  {



    @DataProvider
    public String[][] AddressCredials() throws  Exception{

        return File_Utility.getMultipleData("MultiAddressData");
    }


    @Test(dataProvider = "AddressCredials" )
    public void AddressTest(
            String AdsFirstName,
            String AdsLastName,
            String AdsEmail,
            String Company,
            String CountryName,
            //String StateProvinceId,
            String City,
            String Address1,
            String Address2,
            String ZipPostalCode,
            String PhoneNumber,
            String FaxNumber) throws  Exception{

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(File_Utility.getProperty("url"));

        driver.findElement(By.linkText("Register")).click();
        String Gender = File_Utility.getSingleData("Registration",1,0);
        String FirstName = File_Utility.getSingleData("Registration",1,1);
        String LastName = File_Utility.getSingleData("Registration",1,2);
        String Email = File_Utility.getSingleData("Registration",1,3);
        String Password = File_Utility.getSingleData("Registration",1,4);
        String ConfirmPassword = File_Utility.getSingleData("Registration",1,5);

        if(Gender.equals("Male")){
            driver.findElement(By.id("gender-male")).click();
        } else if (Gender.equals("Female")) {
            driver.findElement(By.id("gender-female")).click();
        }

        driver.findElement(By.id("FirstName")).sendKeys(FirstName);


        driver.findElement(By.id("LastName")).sendKeys(LastName) ;


        driver.findElement(By.id("Email")).sendKeys(Email);



        driver.findElement(By.id("Password")).sendKeys(Password) ;


        driver.findElement(By.id("ConfirmPassword")).sendKeys(ConfirmPassword);

        driver.findElement(By.id("register-button")).click() ;



        Thread.sleep(2000);

        driver.findElement(By.className("ico-login")).click();

        driver.findElement(By.id("Email")).sendKeys(Email);

        driver.findElement(By.id("Password")).sendKeys(Password);

        driver.findElement(By.id("RememberMe")).click();

        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        Thread.sleep(2000);

        //ADDRESSES

        driver.findElement(By.xpath("//a[text()='Addresses']")).click();

        driver.findElement(By.xpath("//input[@type='button']")).click();

        driver.findElement(By.id("Address_FirstName")).clear();
        driver.findElement(By.id("Address_FirstName")).sendKeys(AdsFirstName);

        driver.findElement(By.id("Address_LastName")).clear();
        driver.findElement(By.id("Address_LastName")).sendKeys(AdsLastName);

        driver.findElement(By.id("Address_Email")).clear();
        driver.findElement(By.id("Address_Email")).sendKeys(AdsEmail);

        driver.findElement(By.id("Address_Company")).clear();
        driver.findElement(By.id("Address_Company")).sendKeys(Company);


        Select country = new Select(driver.findElement(By.id("Address_CountryId")));
        country.selectByVisibleText(CountryName);

//        Select state = new Select(driver.findElement(By.id("Address_StateProvinceId")));
//        state.selectByVisibleText(StateProvinceId);

        driver.findElement(By.id("Address_City")).clear();
        driver.findElement(By.id("Address_City")).sendKeys(City);

        driver.findElement(By.id("Address_Address1")).clear();
        driver.findElement(By.id("Address_Address1")).sendKeys(Address1);

        driver.findElement(By.id("Address_Address2")).clear();
        driver.findElement(By.id("Address_Address2")).sendKeys(Address2);

        driver.findElement(By.id("Address_ZipPostalCode")).clear();
        driver.findElement(By.id("Address_ZipPostalCode")).sendKeys(ZipPostalCode);

        driver.findElement(By.id("Address_PhoneNumber")).clear();
        driver.findElement(By.id("Address_PhoneNumber")).sendKeys(PhoneNumber);

        driver.findElement(By.id("Address_FaxNumber")).clear();
        driver.findElement(By.id("Address_FaxNumber")).sendKeys(FaxNumber);

        driver.findElement(By.cssSelector(".button-1.save-address-button")).click();

        driver.quit();
    }

}
