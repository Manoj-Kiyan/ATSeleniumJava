package TakesScreenShot_Interface;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class ScreenShot_Webpage {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver(); //UpCasting

        driver.manage().window().maximize();

        driver.get("https://www.zomato.com/");
//6380476257
        // Call getScreenShot() --> Child --> DownCast
            //        RemoteWebDriver rwd = (RemoteWebDriver) driver;
            //        rwd.getScreenshotAs();
            //           OR
            //        ChromeDriver cd = (ChromeDriver) driver;
            //        cd.getScreenshotAs();
        TakesScreenshot ts = (TakesScreenshot) driver;  //Type Cast
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        File saveDir = new File("src/main/java/TakesScreenShot_Interface/screenshots");
        if (!saveDir.exists()) {
            saveDir.mkdirs();  // create folder if missing
        }

        File saveFile = new File(saveDir, "zomato.png");
        FileHandler.copy(screenshot, saveFile);

        System.out.println("Screen Shot Saved path :" + saveFile.getAbsolutePath());

        driver.quit();


    }
}

