package SwitchToMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class taskAmazon {
    public static void main(String[] args) throws  Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");

        Thread.sleep(2000);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile", Keys.ENTER);

        driver.findElement(By.xpath("(//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal'])[1]")).click();

        //System.out.println(driver.getTitle());

        Thread.sleep(2000);


        Set<String> allwindowIds = driver.getWindowHandles();

        String curWindowId = driver.getWindowHandle();

        //allwindowIds.remove(curWindowId);

        for(String windowId : allwindowIds){

            if(windowId.equals(curWindowId)){
                continue;
            }

            driver.switchTo().window(windowId);

            System.out.println(driver.getTitle());

            driver.findElement(By.xpath("//i[@class='a-icon a-accordion-radio a-icon-radio-inactive']")).click();
        }


    }
}
