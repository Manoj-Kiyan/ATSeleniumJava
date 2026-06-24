package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DragAndDrop {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///D:/Edge%20Downloads/DragandDrop.html");

        Thread.sleep(2000);

        Actions actions = new Actions(driver);

        List<WebElement> capitals = driver.findElements(By.xpath("//div[starts-with(@id,'cap-')]"));

        for (WebElement capital : capitals) {

            String capitalId = capital.getAttribute("id"); // cap-1


            String number = capitalId.split("-")[1];


            WebElement country = driver.findElement(By.id("cc-" + number));

            actions.dragAndDrop(capital, country).perform();

            Thread.sleep(500);
        }

        System.out.println("All capitals matched successfully!");
    }
}