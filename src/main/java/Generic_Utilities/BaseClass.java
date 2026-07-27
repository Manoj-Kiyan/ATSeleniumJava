package Generic_Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.List;

public class BaseClass {
    public WebDriver driver;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void openBrowser(String browser) throws Exception {
        if(browser.equals("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equals("MsEdge")) {
            driver = new EdgeDriver();
        } else if (browser.equals("FireFox")) {
            driver = new FirefoxDriver();
        }else {
            System.out.println("No Other Browser there . . .");
        }

        driver.manage().window().maximize();
        driver.get(File_Utility.getProperty("url"));

        Reporter.log("BROWSER OPENED SUCCESSFULLY . . .",true);
    }
    @BeforeMethod(groups = {"Smoke","Functional"})
    public void setupAndLogin() throws Exception {

        String email = File_Utility.getSingleData("Registration", 1, 3);
        String password = File_Utility.getSingleData("Registration", 1, 4);


        login(email, password);

        List<WebElement> errors = driver.findElements(By.xpath("//div[contains(@class, 'validation-summary-errors')]"));

        if (errors.size() > 0) {
            System.out.println("User not found. Registering new user...");
            register();
        }
        Reporter.log("LOGIN SUCCESSFULLY . . .",true);
    }

    @AfterMethod(alwaysRun = true)
    public void logoutWebShop() throws InterruptedException {
        Thread.sleep(2000);

        List<WebElement> logoutLink = driver.findElements(By.linkText("Log out"));
        if (logoutLink.size() > 0) {
            logoutLink.get(0).click();
        }
        Reporter.log("LOGOUT SUCCESSFULLY . . .",true);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        if (driver != null) {
            driver.quit();
        }
        Reporter.log("BROWSER CLOSED SUCCESSFULLY . . .",true);
    }


    public void login(String email, String password) {
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }

    public void register() throws Exception {
        driver.findElement(By.linkText("Register")).click();

        String Gender = File_Utility.getSingleData("Registration", 1, 0);
        String FirstName = File_Utility.getSingleData("Registration", 1, 1);
        String LastName = File_Utility.getSingleData("Registration", 1, 2);
        String Email = File_Utility.getSingleData("Registration", 1, 3);
        String Password = File_Utility.getSingleData("Registration", 1, 4);
        String ConfirmPassword = File_Utility.getSingleData("Registration", 1, 5);

        if (Gender.equals("Male")) {
            driver.findElement(By.id("gender-male")).click();
        } else if (Gender.equals("Female")) {
            driver.findElement(By.id("gender-female")).click();
        }

        driver.findElement(By.id("FirstName")).sendKeys(FirstName);
        driver.findElement(By.id("LastName")).sendKeys(LastName);
        driver.findElement(By.id("Email")).sendKeys(Email);
        driver.findElement(By.id("Password")).sendKeys(Password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(ConfirmPassword);
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
    }
}