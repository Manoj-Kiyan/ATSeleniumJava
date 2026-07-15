package TestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider {
        @DataProvider
        public String[][] loginDataProvider() {

            String[][] data = new String[3][2];
                data[0][0] = "MK";
                data[0][1] = "2316";
                data[0][2] = "mk@gmail.com";

                data[1][0] = "Manoj";
                data[1][1] = "2311";
                data[1][2] = "mk2@gmail.com";

                data[2][0] = "Kiyan";
                data[2][1] = "1611";
                data[2][2] = "mk3@gmail.com";

                return data;
        }

        @Test(dataProvider = "loginDataProvider")
        public  void login(String userName,String Password,String email){
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get("https://demowebshop.tricentis.com/");

            driver.findElement(By.linkText("Register")).click();

            driver.findElement(By.id("gender-male")).click();


            driver.findElement(By.id("FirstName")).sendKeys(userName);

            driver.findElement(By.id("LastName")).sendKeys(userName);

            driver.findElement(By.id("Email")).sendKeys(email);

            driver.findElement(By.id("Password")).sendKeys(Password);
            driver.findElement(By.id("ConfirmPassword")).sendKeys(Password);

            driver.findElement(By.id("register-button")).click();



            driver.findElement(By.linkText("Log in")).click();

            driver.findElement(By.id("Email")).sendKeys(email);

            driver.findElement(By.id("Password")).sendKeys(Password);

            driver.findElement(By.xpath("//input[@value = 'Log in']")).click();

            driver.quit();
        }

    }
