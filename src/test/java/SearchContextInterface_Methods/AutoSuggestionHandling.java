package SearchContextInterface_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestionHandling {
    public static void main(String[] args) throws  Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://google.com/");

        Thread.sleep(2000);

        driver.findElement(By.id("APjFqb")).sendKeys("Selenium");

        Thread.sleep(3000);
        List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class='wM6W7d']"));

        //WebElement suggestions2 = driver.findElement(By.xpath("(//div[@class='wM6W7d'])[10]"));

        //System.out.println("10th Web Element is : "+suggestions2.getText());
        int i=0;
        for(WebElement suggestion:suggestions){
            //System.out.println(suggestion.getText());

            String text = suggestion.getText();
            if(!text.isEmpty()) {
                System.out.println(++i + " . " + text);
            }
        }
        Thread.sleep(2000);
        //click on particular suggestion:
            //suggestions.get(4).click();
        for (int j = 0; j < suggestions.size(); j++) {

            WebElement element = suggestions.get(j);
            if(element.getText().equals("selenium interview questions")){
                element.click();
                System.out.println();
                System.out.println("selenium interview questions Clicked");
                break;
                //StaleElementReferenceException
                    //If web page has refreshed the address/reference of the Web element has changed that time StaleElementReferenceException will occur.
                    //To overcome this we have to find and assign again (Temporarily)
                    //To solve permanently by using (OBJECT REPOSITORY / POM class)
            }

        }

        driver.navigate().to("https://www.amazon.in/");

        driver.findElement(By.xpath("//input[@id='nav-search-keywords']")).sendKeys("dress");

        List<WebElement> dreses = driver.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));


        int k=0;
        for(WebElement dress :dreses){
            String  name =dress.getText();
            if(!name.isEmpty()) {
                System.out.println(++k + " . " + name);
            }
        }

        for (int j = 0; j < dreses.size(); j++) {

            WebElement dress = dreses.get(j);
        }
        //div[@class='pkKEsC']

        //driver.close();

    }
}
