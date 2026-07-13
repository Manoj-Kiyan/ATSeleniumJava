package SearchContextInterface_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.NoSuchElementException;

public class mobiletask {

    public static void main(String[] args) throws  Exception {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https:/flipkart.com");

        Thread.sleep(2000);

       driver.findElement(By.xpath("//span[@class='b3wTlE']")).click();

        driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("Mobiles");

        driver.findElement(By.xpath("//button[@class='XFwMiH']")).click();


        //Fetch All Mobile names on That Page :

        List<WebElement> mobileNames = driver.findElements(By.xpath("//div[@class='RG5Slk']"));

        List<WebElement> mobilePrices=driver.findElements(By.xpath("//div[@class='hZ3P6w DeU9vF']"));
        List<WebElement> discounts = driver.findElements(By.xpath("//div[@class='RG5Slk']/ancestor::div[@class='ZFwe0M row']/descendant::div[@class='HQe8jr']"));
//        for(WebElement element:mobileName){
//            String name=element.getText();
//
//            System.out.println(name);
//        }
//        for(WebElement element:mobilePrice){
//            String name=element.getText();
//
//            System.out.println(name);
//        }


        for (WebElement mobileName:mobileNames){
            String name=mobileName.getText();
            System.out.println("Mobile name :"+name);

            try {
                WebElement mobilePrice=driver.findElement(By.xpath("//div[text()='"+name+"']/ancestor::div[@class='ZFwe0M row']/descendant::div[@class='hZ3P6w DeU9vF']"));
                System.out.println("Price : "+mobilePrice.getText());
            }catch (NoSuchElementException e){
                System.out.println("Details not given ");
            }
           try {
               WebElement discount = driver.findElement(By.xpath("//div[text()='"+ name +"']/ancestor::div[@class='ZFwe0M row']/descendant::div[@class='HQe8jr']/descendant::span"));
               System.out.println("Discount :"+discount.getText());
           }catch (NoSuchElementException e){
               System.out.println("Details not given");
           }
           try {
               WebElement mrp=driver.findElement(By.xpath("//div[text()='"+ name +"']/ancestor::div[@class='ZFwe0M row']/descendant::div[@class='kRYCnD gxR4EY']"));
               System.out.println("MRP $:"+mrp.getText());
           }catch (NoSuchElementException e){
               System.out.println("Details not given ");
           }
            System.out.println();

        }




    }
}