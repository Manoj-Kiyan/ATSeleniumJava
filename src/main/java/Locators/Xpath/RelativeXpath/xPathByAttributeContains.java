package Locators.Xpath.RelativeXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xPathByAttributeContains {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");

        Thread.sleep(2000);

        //syntax:
        //tagname[contains(@attribute,'partialValue')]
        driver.findElement(By.xpath("//a[contains(@href,'computers')]")).click();

        driver.findElement(By.xpath("//img[contains(@alt,'Picture')]")).click();

        driver.findElement(By.xpath("//div[@class='product-grid']/descendant::div[@class='item-box'][3]/descendant::div[@class='details']/descendant::div[@class='add-info']/descendant::div[@class='buttons']")).click();
    }
}
