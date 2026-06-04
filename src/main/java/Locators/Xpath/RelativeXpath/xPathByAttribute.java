package Locators.Xpath.RelativeXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xPathByAttribute {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");

        Thread.sleep(2000);

        //syntax:
        //tagname[@attribute='value']

        driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Mobiles");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}
