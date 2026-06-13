package WebElementInterface_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getterMethods {
    public static void main(String[] args) throws  Exception{
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");

        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//div[@class='search-box']/descendant::input[@class='search-box-text ui-autocomplete-input valid']"));
        element.sendKeys("Mobiles");
        
        //getText Method():
        System.out.println(element.getText());

        //getTagName Method():


        //getAttribute Method(String AttributeName):


        //getDOMattribute Method(String AttributeName):


        //getCSSvalue Method(Strinf CssPropertyName):


        //getSize Method():
    }
}
