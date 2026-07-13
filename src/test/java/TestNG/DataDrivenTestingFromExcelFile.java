package TestNG;

import Generic_Utilities.File_Utility;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.apache.poi.common.usermodel.HyperlinkType.EMAIL;

public class DataDrivenTestingFromExcelFile  {

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
        driver.close();
    }
}
