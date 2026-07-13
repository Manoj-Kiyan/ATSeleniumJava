package TestNG;

import Generic_Utilities.File_Utility;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.apache.poi.common.usermodel.HyperlinkType.EMAIL;
import static org.apache.poi.common.usermodel.HyperlinkType.FILE;

public class DataDrivenTestingFromExcelFile2  {

    @Test
    public void registerTest() throws Exception {

        FileInputStream file = new FileInputStream("./src/test/resources/testScriptData.xlsx");

        //Open the workbook in read mode:
        Workbook sheets = WorkbookFactory.create(file);
        Sheet sheet = sheets.getSheet("Registration");

        Row row = sheet.getRow(1);

        Cell cell = row.getCell(0);

        String Gender = cell.toString();
        String FirstName =row.getCell(1).toString();
        String LastName = row.getCell(2).toString();
        String Email= row.getCell(3).toString();
        String Password=row.getCell(4).toString();
        String ConfirmPassword=row.getCell(5).toString();


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(File_Utility.getProperty("url"));

        driver.findElement(By.linkText("Register")).click();

        if(Gender.equals("Male")){
            driver.findElement(By.id("gender-male")).click();
        } else if (Gender.equals("Female")) {
            driver.findElement(By.id("gender-female")).click();
        }

        driver.findElement(By.id("FirstName")).sendKeys(FirstName) ;


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

        driver.findElement(By.xpath("//a[text()='Addresses']")).click();

        driver.findElement(By.xpath("//input[@type='button']")).click();

        Thread.sleep(3000);

        //ADDRESSES

        //FileInputStream ads = new FileInputStream("./src/test/resources/AddressData.xlsx");

//        Workbook sheets2 = WorkbookFactory.create(file);
//        Sheet sheet2 =sheets2.getSheet("Address");
        Sheet sheet2 = sheets.getSheet("Address");

        Row row2 = sheet2.getRow(1);



        String AdsFirstName = row2.getCell(0).getStringCellValue();
        String  AdsLastName = row2.getCell(1).getStringCellValue();
        String  AdsEmail =row2.getCell(2).getStringCellValue();
        String   Company = row2.getCell(3).getStringCellValue();
        String  CountryId = row2.getCell(4).toString();
        String  StateProvinceId = row2.getCell(5).toString();
        String    City=row2.getCell(6).getStringCellValue();
        String  Address1 = row2.getCell(7).getStringCellValue();
        String  Address2 = row2.getCell(8).getStringCellValue();
        String  ZipPostalCode = row2.getCell(9).toString();
        String    PhoneNumber = row2.getCell(10).toString();
        String  FaxNumber = row2.getCell(11).toString();

        driver.findElement(By.id("Address_FirstName")).sendKeys(AdsFirstName);

        driver.findElement(By.id("Address_LastName")).sendKeys(AdsLastName);

        driver.findElement(By.id("Address_Email")).sendKeys(AdsEmail);

        driver.findElement(By.id("Address_Company")).sendKeys(Company);

        Select country = new Select(driver.findElement(By.id("Address_CountryId")));
        country.selectByVisibleText(CountryId);

        Select state = new Select(driver.findElement(By.id("Address_StateProvinceId")));
        state.selectByVisibleText(StateProvinceId);

        driver.findElement(By.id("Address_City")).sendKeys(City);

        driver.findElement(By.id("Address_Address1")).sendKeys(Address1);

        driver.findElement(By.id("Address_Address2")).sendKeys(Address2);

        driver.findElement(By.id("Address_ZipPostalCode")).sendKeys(ZipPostalCode);

        driver.findElement(By.id("Address_PhoneNumber")).sendKeys(PhoneNumber);

        driver.findElement(By.id("Address_FaxNumber")).sendKeys(FaxNumber);

        driver.findElement(By.cssSelector(".button-1.save-address-button")).click();




    }
}
