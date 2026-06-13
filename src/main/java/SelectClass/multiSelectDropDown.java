package SelectClass;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.util.List;
//import java.util.logging.FileHandler;
import  java.util.*;

public class multiSelectDropDown {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");

        Thread.sleep(2000);

        WebElement multiDrop = driver.findElement(By.name("Month"));

        Select muliDropDown = new Select(multiDrop);

        List<WebElement> options = muliDropDown.getOptions();
        int i =0 ;
        for(WebElement option:options){

            if(!option.getText().equals("Month...")){
                System.out.println( ++i+ " . "+option.getText());
            }

        }


        System.out.println("MULTI SELECT DROP DOWN METHODS :");

        muliDropDown.selectByIndex(3);
        Thread.sleep(2000);
        muliDropDown.selectByValue("Jan");

        Thread.sleep(2000);
        muliDropDown.selectByVisibleText("April");

        Thread.sleep(2000);
        muliDropDown.selectByContainsVisibleText("Oct");


        TakesScreenshot ts =(TakesScreenshot) driver;

        File src = ts.getScreenshotAs(OutputType.FILE);

        File dest = new File("src/main/java/SelectClass");

        File name = new File(dest,"select.png");

        FileHandler.copy(src,name);


        System.out.println("DESELECT MULTI SELECT DROP DOWN");

        try {
            if(muliDropDown.isMultiple()){
                muliDropDown.deselectByIndex(3);
                Thread.sleep(2000);

                muliDropDown.deselectByValue("Jan");
                Thread.sleep(2000);

                muliDropDown.deselectByVisibleText("April");
                Thread.sleep(2000);

                muliDropDown.selectByContainsVisibleText("Oct");

                muliDropDown.deselectAll();

                src = ts.getScreenshotAs(OutputType.FILE);

                name = new  File(dest,"DeSelect.png");

                FileHandler.copy(src,name);
            }
        }catch (Exception e){
            System.out.println("DROP DOWN IS SINGLE SELECT");
        }
    //driver.quit();
    }

}
