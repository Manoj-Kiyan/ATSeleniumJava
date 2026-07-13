package SwitchToMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class newTab {
    public static void main(String[] args) throws  Exception {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https:/facebook.com/");

        Thread.sleep(2000);

        driver.switchTo().newWindow(WindowType.WINDOW).get("https:/instagram.com/");

       driver.switchTo().newWindow(WindowType.TAB).get("https:/x.com");

       driver.navigate().to("https:/instagram.com/");


        //driver.close();  //current window close

        //driver.quit();  //Close all window

    }
}
