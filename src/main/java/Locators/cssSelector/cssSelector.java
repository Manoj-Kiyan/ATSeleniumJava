package Locators.cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//tag id   --> tag#id
//tag class --> tag.classname
//tag attribute --> tag[attribute = "value"]
//tag class attribute --> tag.classname[attribute ="value"]

public class cssSelector {
    public static void main(String[] args) throws  Exception {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        //tag id   --> tag#id
        driver.findElement(By.cssSelector("input#_R_1h6kqsqppb6amH1_")).sendKeys("Manoj2316@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("Manoj2316@");

        driver.findElement(By.xpath("//span[text()=\"Log in\"]")).click();

    }
}
