package TakesScreenShot_Interface;

import LaunchBrowsers.BrowserMismatchException;
import LaunchBrowsers.UnsupportedBrowsersException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.util.Scanner;

public class practice {
    public static void main(String[] args) throws Exception {

        WebDriver driver = null;
        Scanner sc = new Scanner(System.in);
        boolean isRun = true;
        while (isRun) {

            System.out.println("Select browser:");
            System.out.println("1. Chrome");
            System.out.println("2. Edge");
            System.out.println("3. Firefox");
            System.out.println("4. Safari (Mac only)");
            System.out.println("5. Internet Explorer");
            System.out.println("6. Exit");
            System.out.println("Enter Your Choice here :");
            int choice = sc.nextInt();
            System.out.println("Enter the application Name to open :");
            String applicationName = sc.next();
            System.out.println("1. Title \n 2.URL ");
            int input = sc.nextInt();


            try {
                switch (choice) {
                    case 1:
                        try {
                            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                            driver = new ChromeDriver();
                            takescr(driver);
                            System.out.println("Chrome launched successfully!");
                            runApp(driver,applicationName,input);
                            driver.quit();

                        } catch (Exception e) {
                            System.out.println("Chrome browser not installed on your system");
                        }
                        break;

                    case 2:
                        try {
                            System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
                            driver = new EdgeDriver();
                            System.out.println("Edge launched successfully!");
                            takescr(driver);
                            runApp(driver,applicationName,input);
                            driver.quit();
                        } catch (Exception e) {
                            System.out.println("Edge browser not installed on your system");
                        }
                        break;

                    case 3:
                        try {
                            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
                            driver = new FirefoxDriver();
                            takescr(driver);
                            System.out.println("Firefox launched successfully!");
                            runApp(driver,applicationName,input);
                            driver.quit();
                        } catch (Exception e) {
                            System.out.println("Firefox browser not installed on your system");
                        }
                        break;

                    case 4:
                        try {
                            driver = new SafariDriver();
                            takescr(driver);
                            System.out.println("Safari launched successfully!");
                            runApp(driver,applicationName,input);
                            driver.quit();
                        } catch (BrowserMismatchException e) {
                            throw new BrowserMismatchException("Safari is not supported on Windows");
                        } catch (Exception e) {
                            System.out.println("Safari browser not installed on your system");
                        }
                        break;

                    case 5:
                        try {
                            System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
                            driver = new InternetExplorerDriver();
                            takescr(driver);
                            System.out.println("Internet Explorer launched successfully!");
                            runApp(driver,applicationName,input);
                            driver.quit();
                        } catch (Exception e) {
                            System.out.println("Internet Explorer browser not installed on your system");
                        }
                        break;
                    case 6:
                        isRun = false;
                        System.out.println("See You Again  . . . !");
                        break;

                    default:
                        String browserName = sc.next();
                        throw new UnsupportedBrowsersException(browserName);
                }

            } catch (UnsupportedBrowsersException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public  static  void runApp(WebDriver driver,String applicationName,int input) throws Exception{
        driver.manage().window().maximize();
        driver.get("https://www."+ applicationName +".com");
        if(input == 1) {
            String pageTitle = driver.getTitle();
            System.out.println("The page title is: " + pageTitle);
        } else if (input == 2) {
            String URL = driver.getCurrentUrl();
            System.out.println("The Page URL is : "+ URL);
        }else {
            System.out.println("Invalid Choice  . . . !");
        }
        Thread.sleep(2000);
        driver.quit();

    }
    public static  void takescr(WebDriver driver) throws  Exception{
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        TakesScreenshot ts = (TakesScreenshot) driver;

        File screenshot = ts.getScreenshotAs(OutputType.FILE);

        File dir = new File("src/main/java/TakesScreenShot_Interface/screenshots");
        File file = new File(dir,"homepage.png");
        FileHandler.copy(screenshot,file);

        Thread.sleep(2000);

        driver.navigate().to("https://www.amazon.in/ap/signin?openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fs%3Fk%3Djoin%2Bamazon%2Bprime%26adgrpid%3D1327112148528381%26hvadid%3D82944775541359%26hvbmt%3Dbb%26hvdev%3Dc%26hvlocphy%3D157235%26hvnetw%3Do%26hvqmt%3Db%26hvtargid%3Dkwd-82945393014646%253Aloc-90%26hydadcr%3D5626_2377281%26mcid%3D3861a9d242543041b997efa1f39279d3%26msclkid%3De1027606b38d1ef371a21ff8523025d3%26tag%3Dmsndeskstdin-21%26ref%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        screenshot = ts.getScreenshotAs(OutputType.FILE);
        file = new File(dir,"signin_page.png");
        FileHandler.copy(screenshot,file);

        Thread.sleep(2000);

        driver.navigate().to("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
        screenshot = ts.getScreenshotAs(OutputType.FILE);
        file = new File(dir,"cart_page.png");
        FileHandler.copy(screenshot,file);

        Thread.sleep(2000);

    }
}
