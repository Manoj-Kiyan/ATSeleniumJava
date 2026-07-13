package LaunchBrowsers;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;



public class RuntimePolymorphism {

    public static void main(String[] args) {
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

            try {
                switch (choice) {
                    case 1:
                        try {
                            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                            WebDriver driver= new ChromeDriver();
                            driver.manage().window().maximize();
                            System.out.println("Chrome launched successfully!");

                        } catch (Exception e) {
                            System.out.println("Chrome browser not installed on your system");
                        }
                        break;

                    case 2:
                        try {
                            System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
                            WebDriver driver = new EdgeDriver();
                            driver.manage().window().maximize();
                            System.out.println("Edge launched successfully!");
                        } catch (Exception e) {
                            System.out.println("Edge browser not installed on your system");
                        }
                        break;

                    case 3:
                        try {
                            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
                            WebDriver driver = new FirefoxDriver();
                            driver.manage().window().maximize();
                            System.out.println("Firefox launched successfully!");
                        } catch (Exception e) {
                            System.out.println("Firefox browser not installed on your system");
                        }
                        break;

                    case 4:
                        try {
                            WebDriver driver = new SafariDriver();
                            driver.manage().window().maximize();
                            System.out.println("Safari launched successfully!");
                        } catch (BrowserMismatchException e) {
                            throw new BrowserMismatchException("Safari is not supported on Windows");
                        } catch (Exception e) {
                            System.out.println("Safari browser not installed on your system");
                        }
                        break;

                    case 5:
                        try {
                            System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
                            WebDriver driver  = new InternetExplorerDriver();
                            driver.manage().window().maximize();
                            System.out.println("Internet Explorer launched successfully!");
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
}
