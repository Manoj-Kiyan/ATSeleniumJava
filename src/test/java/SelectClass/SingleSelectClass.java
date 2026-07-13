package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SingleSelectClass {
    public static void main(String[] args) throws  Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https:/flipkart.com/");

        Thread.sleep(2000);


        driver.findElement(By.xpath("//span[@class='b3wTlE']")).click();

        driver.findElement(By.name("q")).sendKeys("Mobiles",Keys.ENTER);

        WebElement dropdown = driver.findElement(By.className("hbnjE2"));

        Select DropMenu = new Select(dropdown);

        //Select By Index :
        DropMenu.selectByIndex(2);

        //Select By Value :
        DropMenu.selectByValue("20000");

        //Select By Value :
        DropMenu.selectByValue("30000");

        //Select By Text
        //DropMenu.selectByVisibleText("30");

        //Select By Contains Text
        DropMenu.selectByContainsVisibleText("10");

        WebElement firstSelectedOption = DropMenu.getFirstSelectedOption();
        System.out.println("First Selected option from the DropDown is: "+firstSelectedOption.getText());

        List<WebElement> options = DropMenu.getOptions();

        System.out.println("The Options are present in the DropDown are :");
        for(WebElement ele:options){
            System.out.println(ele.getText());
        }

    }
}
