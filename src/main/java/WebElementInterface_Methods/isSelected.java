package WebElementInterface_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class isSelected {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(2000);


        List<WebElement> radioButtons = driver.findElements(By.xpath("//li[@class='answer']/input"));

        for (WebElement element : radioButtons) {
            String value = element.getAttribute("value"); // 1=Excellent, 2=Good, etc.

            if (value.equals("2")) { // "Good"
                element.click();
                System.out.println("Radio button 'Good' selected? " + element.isSelected());
            }
        }


        driver.quit();
    }
}
