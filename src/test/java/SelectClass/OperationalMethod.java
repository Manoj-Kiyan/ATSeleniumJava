package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OperationalMethod {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");

        Thread.sleep(2000);

        WebElement  dropElement = driver.findElement(By.name("country"));

        Select  dropDown = new Select(dropElement);

        List<WebElement> options = dropDown.getOptions();


        int i = 0 ;
        for (WebElement option:options){
            String text = option.getText();
            //System.out.println(text);
            if(i % 2 != 0){

                //SELECT BY INDEX
                System.out.print(i + " . " + text + " = ");
                dropDown.selectByIndex(i);

                //SELECT BY VALUE
                //String value = options.get(i).getAttribute("value");
                String value = option.getAttribute("value");
                System.out.print(value+" ----> ");
                dropDown.selectByValue(value);

                //SELECT BY TEXT
                String text2 = option.getText();
                System.out.println(text2);

            }
            i++;
        }
    driver.quit();


    }
}
