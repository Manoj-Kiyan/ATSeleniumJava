package Locators.cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//tag id   --> tag#id
//tag class --> tag.classname
//tag attribute --> tag[attribute = "value"]
//tag class attribute --> tag.classname[attribute ="value"]
/*
// By ID
driver.findElement(By.cssSelector("input#email")).sendKeys("Manoj2316@gmail.com");

// By Class
driver.findElement(By.cssSelector("button.login")).click();

// By Attribute
driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("Manoj2316@");

// By Multiple Attributes
driver.findElement(By.cssSelector("input[type='text'][name='username']")).sendKeys("Manoj");

// Starts With
driver.findElement(By.cssSelector("input[id^='user']")).sendKeys("Test");

// Ends With
driver.findElement(By.cssSelector("input[id$='name']")).sendKeys("Test");

// Contains
driver.findElement(By.cssSelector("input[id*='login']")).sendKeys("Test");

// Parent > Child
driver.findElement(By.cssSelector("div.login > input#email")).sendKeys("Test");

// nth-child
driver.findElement(By.cssSelector("ul li:nth-child(2)")).click();

 */

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
