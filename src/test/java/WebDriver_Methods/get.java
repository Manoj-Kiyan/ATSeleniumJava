package WebDriver_Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class get {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.facebook.com/"); //GET

        String url =driver.getCurrentUrl();     //GET URL
        System.out.println(url);

        String title = driver.getTitle();
        System.out.println(title);

        String pgSource = driver.getPageSource();   // GET page source
        System.out.println(pgSource);


        driver.navigate().to("https://www.instagram.com");

        driver.close();
    }
}
