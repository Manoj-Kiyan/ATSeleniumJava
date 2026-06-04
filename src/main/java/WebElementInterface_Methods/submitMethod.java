package WebElementInterface_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class submitMethod {
    public static void main(String[] args) throws  Exception {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");

        Thread.sleep(2000);

        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("Mobiles");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@type='submit']")).submit();

        driver.quit();
    }


}



/*
Submit Method is only work which is must be come under <form> tag  and input tag type should be submit (<input type="submit">)
and button tag type also should be submit (<button type="submit">).
submit method not for components like radio button and check box etc . . .
 */

