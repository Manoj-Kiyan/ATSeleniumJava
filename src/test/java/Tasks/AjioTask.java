package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.awt.SystemColor.window;

public class AjioTask {
    public static void main(String[] args) throws  Exception {
        WebDriver driver = new ChromeDriver();
        Select dropDown = null;
        driver.manage().window().maximize();

        driver.get("https://stores.easybuyindia.com/");

        WebElement states= driver.findElement(By.id("OutletState"));
         dropDown = new Select(states);

        List<WebElement> StateOptions = dropDown.getOptions();
        for(WebElement StateOption: StateOptions){
            String allOptions = StateOption.getText();
            System.out.println(allOptions);
            if(allOptions.equals("Tamil Nadu")){
                dropDown.selectByContainsVisibleText("Tamil");
            }
        }

        WebElement cities = driver.findElement(By.id("OutletCity"));
        dropDown = new Select(cities);

        List<WebElement> CityOptions  = dropDown.getOptions();
        for(WebElement CityOption : CityOptions){
            String cityName = CityOption.getText();

            System.out.println();
            if(cityName.equals("Chennai")){
                dropDown.selectByContainsVisibleText("Chennai");
            }
        }

        WebElement locality= driver.findElement(By.id("OutletLocality"));
        dropDown = new Select(locality);

        List<WebElement> localityOptions = dropDown.getOptions();
        for (WebElement localityOption: localityOptions){
            String locName = localityOption.getText();


            if(locName.equals("Anna Salai (Mount Road)")){
                dropDown.selectByContainsVisibleText("Anna");
            }
        }

        driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).click();

        String curTitle = driver.getTitle();

        if(curTitle.contains("Anna")){
            String curWindowId=driver.getWindowHandle();
           driver.switchTo().window(curWindowId);
        }
       driver.findElement(By.xpath("//a[@data-track-event-click='Website']")).click();

    }
}
