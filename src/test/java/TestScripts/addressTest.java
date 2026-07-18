package TestScripts;

import Generic_Utilities.BaseClass;
import Generic_Utilities.File_Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class addressTest extends BaseClass {


    @DataProvider
    public String[][] AddressCredials() throws Exception {
        return File_Utility.getMultipleData("MultiAddressData");
    }


    @Test(dataProvider = "AddressCredials",priority = 1)
    public void addToAddressTest(
            String AdsFirstName, String AdsLastName, String AdsEmail,
            String Company, String CountryName, String City,
            String Address1, String Address2, String ZipPostalCode,
            String PhoneNumber, String FaxNumber) throws Exception {

        driver.findElement(By.xpath("//a[text()='Addresses']")).click();
        driver.findElement(By.xpath("//input[@type='button']")).click(); // "Add new" button

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
    }


    @Test(priority = 2)
    public void updateAddressTest() {

        driver.findElement(By.xpath("//a[text()='Addresses']")).click();


        driver.findElement(By.xpath("(//input[@value='Edit'])[1]")).click();


        driver.findElement(By.id("Address_City")).clear();
        driver.findElement(By.id("Address_City")).sendKeys("New City");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
    }


    @Test(priority = 3)
    public void deleteAddressTest() {

        driver.findElement(By.xpath("//a[text()='Addresses']")).click();

        driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();

        driver.switchTo().alert().accept();
    }
}