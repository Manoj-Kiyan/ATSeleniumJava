package TestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;

public class extendReport {
    @Parameters({"Url","FirstName","LastName","Email","Password","ConfirmPassword"})
    @Test
    public void loginTest(String Url,
                          String FirstName,
                          String LastName,
                          String Email,
                          String Password,
                          String ConfirmPassword) {

        // Create Reports folder if it doesn't exist
        File folder = new File("./Reports");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Create Spark Report
        ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/DemoWebShopReport.html");

        // Attach Reporter
        ExtentReports report = new ExtentReports();
        report.attachReporter(spark);

        // Optional Report Information
        report.setSystemInfo("Tester", "Manoj");
        report.setSystemInfo("Browser", "Chrome");
        report.setSystemInfo("Environment", "QA");

        // Create Test
        ExtentTest test = report.createTest("Demo Web Shop Registration & Login Test");

        WebDriver driver = null;

        try {

            driver = new ChromeDriver();

            driver.manage().window().maximize();
            test.info("Browser launched successfully.");

            driver.get(Url);
            test.info("Application opened.");

            // Registration
            driver.findElement(By.linkText("Register")).click();
            driver.findElement(By.id("gender-male")).click();

            driver.findElement(By.id("FirstName")).sendKeys(FirstName);
            driver.findElement(By.id("LastName")).sendKeys(LastName);
            driver.findElement(By.id("Email")).sendKeys(Email);
            driver.findElement(By.id("Password")).sendKeys(Password);
            driver.findElement(By.id("ConfirmPassword")).sendKeys(ConfirmPassword);

            driver.findElement(By.id("register-button")).click();

            test.pass("User Registered Successfully.");

            // Login
            driver.findElement(By.linkText("Log in")).click();

            driver.findElement(By.id("Email")).sendKeys(Email);
            driver.findElement(By.id("Password")).sendKeys(Password);

            driver.findElement(By.xpath("//input[@value='Log in']")).click();

            test.pass("User Logged In Successfully.");

        }
        catch (Exception e) {

            test.log(Status.FAIL, "Test Failed");
            test.fail(e.getMessage());

            throw e;
        }
        finally {

            if (driver != null) {
                driver.quit();
                test.info("Browser Closed.");
            }

            report.flush();

            System.out.println("Report Generated Successfully.");
            System.out.println(new File("./Reports/DemoWebShopReport.html").getAbsolutePath());
        }
    }
}