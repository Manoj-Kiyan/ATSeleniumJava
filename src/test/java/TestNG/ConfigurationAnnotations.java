package TestNG;

import org.testng.Reporter;
import org.testng.annotations.*;

import javax.sound.midi.Soundbank;


public class ConfigurationAnnotations {

    @Test(priority = 2)
    public void addToCart(){
        Reporter.log("PRODUCT ADDED INTO CART SUCCESSFULLY",true);
    }

    @Test(priority = 3)
    public void purchaseProduct(){
        Reporter.log("PRODUCT PURCHASE SUCCESSFULLY",true);
    }

    @Test(priority = 1)
    public void searchProduct(){
        Reporter.log("PRODUCT SEARCH SUCCESSFULLY",true);
    }

    @BeforeSuite
    public void  beforeSuite(){
        Reporter.log("Report Generating started . . .",true);
        System.out.println();
    }

    @AfterSuite
    public  void afterSuite(){
        Reporter.log("Report Saved/Closed . . .",true);
    }

    @BeforeTest
    public void  beforeTest(){
        Reporter.log("CONNECTION WITH DATABASE",true);
    }

    @AfterTest
    public  void afterTest(){
        Reporter.log("CLOSE CONNECTION WITH DATABASE",true);
    }

    @BeforeClass
    public void  beforeClass(){
        Reporter.log("BROWSER LAUNCHED",true);
        System.out.println();
        System.out.println("**************");
        System.out.println("TestCase Running  . . .");
        System.out.println();
    }

    @AfterClass
    public  void afterClass(){
        Reporter.log("BROWSER CLOSED",true);
    }

    @BeforeMethod
    public void  beforeMethod(){
        Reporter.log("USER LOGIN",true);
        Reporter.log("***************");
    }

    @AfterMethod
    public  void afterMethod(){
        Reporter.log("USER LOGOUT",true);
        System.out.println();
        Reporter.log("***************");
    }
}
