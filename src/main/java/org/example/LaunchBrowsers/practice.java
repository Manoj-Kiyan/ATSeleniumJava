package org.example.LaunchBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

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

                            System.out.println("Chrome launched successfully!");
                            runApp(driver,applicationName,input);

                        } catch (Exception e) {
                            System.out.println("Chrome browser not installed on your system");
                        }
                        break;

                    case 2:
                        try {
                            System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
                            driver = new EdgeDriver();
                            System.out.println("Edge launched successfully!");
                            runApp(driver,applicationName,input);
                        } catch (Exception e) {
                            System.out.println("Edge browser not installed on your system");
                        }
                        break;

                    case 3:
                        try {
                            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
                            driver = new FirefoxDriver();
                            System.out.println("Firefox launched successfully!");
                            runApp(driver,applicationName,input);
                        } catch (Exception e) {
                            System.out.println("Firefox browser not installed on your system");
                        }
                        break;

                    case 4:
                        try {
                            driver = new SafariDriver();
                            System.out.println("Safari launched successfully!");
                            runApp(driver,applicationName,input);
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
                            System.out.println("Internet Explorer launched successfully!");
                            runApp(driver,applicationName,input);
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
}
