package SearchContextInterface_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class practice1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");

        driver.navigate().to("https://demowebshop.tricentis.com/register");

        Thread.sleep(2000);

        List<WebElement> textelements=driver.findElements(By.xpath("//input[@type='text' or @type='password']"));
        System.out.println(textelements.size());

        for (int i = 0; i < textelements.size(); i++) {

                //String textfieldName = textelements.get(i).getText();
                //System.out.println("Enter the data on " + textfieldName + "text field :");
                //textelements.get(i).sendKeys(sc.next());
                Random random = new Random();
                int num =random.nextInt();
                textelements.get(i).sendKeys(" "+num);
        }


        List<WebElement> radioelement = driver.findElements(By.cssSelector("[type='radio']"));
        System.out.println(radioelement.size());
        for(WebElement ele:radioelement) {
            String ans = ele.getAttribute("value");
            //System.out.println(ans);
            if (ans.equals("M")) {
                ele.click();
            }
        }


        List<WebElement> buttonElement = driver.findElements(By.xpath("//input[@type='button' or @type='submit']"));
        System.out.println(buttonElement.size());
        for(WebElement ele : buttonElement){

            String ans = ele.getAttribute("value");

            System.out.println(ans);
        }


    }
}
