package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CiickandHold {
    public static void main(String[] args) throws  Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoapps.qspiders.com/ui/clickHold?sublist=0");

        Thread.sleep(2000);

        WebElement circle = driver.findElement(By.id("circle"));

        Actions action = new Actions(driver);

       action.moveToElement(circle).clickAndHold(circle).perform();
       Thread.sleep(2000);
       action.release(circle).perform();

        Thread.sleep(2000);

        action.release();


    }
}
