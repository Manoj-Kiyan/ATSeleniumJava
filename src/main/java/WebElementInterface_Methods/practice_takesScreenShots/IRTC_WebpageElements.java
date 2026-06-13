package WebElementInterface_Methods.practice_takesScreenShots;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class IRTC_WebpageElements {

    public static void takesScreenShot(WebElement element,String ElementName){

        File src= element.getScreenshotAs(OutputType.FILE);

        File dest = new File("src/main/java/WebElementInterface_Methods/practice_takesScreenShots/ScreenShots/WE_"+ElementName+".png");

        try {
            FileHandler.copy(src,dest);
        }catch (IOException E){
            System.out.println(E.getMessage());
        }


    }
    public static void main(String[] args) throws  Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.irctc.co.in/nget/train-search");

        Thread.sleep(2000);



        //1. PNR Status:
        WebElement PNR = driver.findElement(By.xpath("//div[@class='text-center pull-left']"));
        takesScreenShot(PNR,"PNR");

        //2. Charts/Vaccancy :
        WebElement vaccancy=driver.findElement(By.xpath("//div[@class='text-center pull-right']"));
        takesScreenShot(vaccancy,"VACCANCY");

        //3. Book Ticket Heading
        WebElement heading =driver.findElement(By.xpath("//label[@class='heading-font']"));
        takesScreenShot(heading,"HEADING");

        //4. From Point
        WebElement FromPoint = driver.findElement(By.xpath("//input[contains(@aria-label,'Enter From station')]"));
        takesScreenShot(FromPoint,"FROMPOINT");

        //5. To Point
        WebElement ToPoint = driver.findElement(By.xpath("//input[contains(@aria-label,'Enter To station')]"));
        takesScreenShot(ToPoint,"TOPOINT");

        //6. Date
        WebElement date = driver.findElement(By.xpath("//input[contains(@class,'ng-tns-c69-9')]"));
        takesScreenShot(date,"DATE");


        //7. All Classes
        WebElement allClasses=driver.findElement(By.xpath("//input[contains(@class,'ng-tns-c76-10 ui-dropdown')]"));
        takesScreenShot(allClasses,"ALLCLASSES");

        //8. General
        WebElement general = driver.findElement(By.xpath("//div[contains(@class,'ng-tns-c76-11 ui-dropdown')]"));
        takesScreenShot(general,"GENERAL");


        //9.1 CheckBox 1
        WebElement checkBox1 = driver.findElement(By.xpath("//span[@class='ng-star-inserted'][1]"));
        takesScreenShot(checkBox1,"CHECK1");

        //9.2 Check Box 2
        WebElement checkBox2 =driver.findElement(By.xpath("//label[text()='Flexible With Date']/ancestor::span"));
        takesScreenShot(checkBox2,"CHECK2");

        //9.3 Chexk Box 3
        WebElement checkBox3 =driver.findElement(By.xpath("//span[@class='ng-star-inserted'][1]"));
        takesScreenShot(checkBox3,"CHECK3");

        //10. Search Trains
        WebElement seatchTrain = driver.findElement(By.xpath("//button[text()=' Search Trains ']/ancestor::div[contains(@class,'col-md-4')]"));
        takesScreenShot(seatchTrain,"SEARCH");


    }
}
