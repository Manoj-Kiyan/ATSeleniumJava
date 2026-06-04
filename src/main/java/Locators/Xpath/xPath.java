package Locators.Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xPath {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.flipkart.com/");

        driver.manage().window().maximize();
        Thread.sleep(2000);


        //Relative xPath :
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("8148002316");
        //driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/form/div[3]/button")).click();


//        Build a relative XPath manually:
//
//        By attribute:
//
//        xpath
////input[@name='username']
//        By class:
//
//        xpath
////div[@class='login-form']//input
//        By text:
//
//        xpath
////button[text()='Login']
//        By partial match:
//
//        xpath
////input[contains(@class,'email')]
        //Abssolute xPath :
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("8248992657");
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/form/div[3]/button")).click();
    }
}
//What is XPath?
//XPath (XML Path Language) is a query language used to navigate through elements and attributes in an XML/HTML document.
//        In Selenium, XPath helps locate web elements when other locators (id, name, class) are not sufficient.
//
//Q1: What is the difference between Absolute and Relative XPath?
//A1: Absolute XPath gives the full path from the root node, fragile if DOM changes. Relative XPath starts from anywhere in the DOM, uses attributes, and is more stable — hence preferred in Selenium automation.
//
//        Q2: Why do we use XPath when other locators exist?
//A2: XPath can locate complex elements when id, name, or class are missing or dynamic. It supports functions like contains() and starts-with() for flexible matching.
//
//Q3: Which XPath type is recommended in real projects?
//A3: Relative XPath, because it’s shorter, readable, and less likely to break when the page structure changes.