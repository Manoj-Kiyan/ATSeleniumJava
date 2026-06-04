package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class tagName {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();

        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        inputs.get(0).sendKeys("manojkiyan23032004@gmail.com");
        inputs.get(1).sendKeys("Manoj2316@");
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div/div[1]/div/div[3]/div/div"));


    }
}
