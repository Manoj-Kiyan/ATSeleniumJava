package TakesScreenShot_Interface;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class screenshot_practice {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver","./driver/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();



        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);

        File dir = new File("src/main/java/TakesScreenShot_Interface/screenshots");
        File file = new File(dir,"homepage.png");
        FileHandler.copy(screenshot,file);

        Thread.sleep(2000);

        driver.navigate().to("https://www.amazon.in/ap/signin?openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fs%3Fk%3Djoin%2Bamazon%2Bprime%26adgrpid%3D1327112148528381%26hvadid%3D82944775541359%26hvbmt%3Dbb%26hvdev%3Dc%26hvlocphy%3D157235%26hvnetw%3Do%26hvqmt%3Db%26hvtargid%3Dkwd-82945393014646%253Aloc-90%26hydadcr%3D5626_2377281%26mcid%3D3861a9d242543041b997efa1f39279d3%26msclkid%3De1027606b38d1ef371a21ff8523025d3%26tag%3Dmsndeskstdin-21%26ref%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        screenshot = ts.getScreenshotAs(OutputType.FILE);
        file = new File(dir,"signin_page.png");
        FileHandler.copy(screenshot,file);

        Thread.sleep(2000);

        driver.navigate().to("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
        screenshot = ts.getScreenshotAs(OutputType.FILE);
        file = new File(dir,"cart_page.png");
        FileHandler.copy(screenshot,file);

        Thread.sleep(2000);






    }
}
