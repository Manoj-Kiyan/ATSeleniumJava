package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class mouse_hover_action {
    public static void main(String[] args) throws  Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoapps.qspiders.com/ui/mouseHover?sublist=0");

        Thread.sleep(3000);

        List<WebElement> Passsuggestions = driver.findElements(By.xpath("//li[@class='text-sm list-disc ml-5 p-1']"));
        Actions action = new Actions(driver);
        WebElement info = driver.findElement(By.xpath("//img[contains(@class,'w-5')]"));

        action.scrollToElement(info).moveToElement(info).perform();
        int i = 0;
        for(WebElement element:Passsuggestions){

            String text = element.getText();
            //System.out.println(text);
            System.out.println(++i + " . "+text);
        }
        //driver.quit();

    }
}
