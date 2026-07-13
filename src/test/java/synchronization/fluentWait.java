package synchronization;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class fluentWait  {
    public static void main(String[] args) throws  Exception {

      WebDriver driver = new ChromeDriver();

      driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(700)).ignoring(NoSuchElementException.class);


    }
}
