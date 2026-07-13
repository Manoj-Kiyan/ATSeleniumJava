package SwitchToMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class AlertPopPup {
    public static void main(String[] args) throws  Exception {
        Scanner sc = new Scanner(System.in);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        Thread.sleep(3000);

        List<WebElement> alertsButtons = driver.findElements(By.className("//ul/descendant::li/descendant::button[text()]"));

        for(WebElement alertButton:alertsButtons){


            String buttonText = alertButton.getText();
            System.out.println("The alert button name is "+buttonText);

            if(buttonText.equals("Click for JS Alert")){
                alertButton.click();
                driver.switchTo().alert().accept();

            }else if(buttonText.equals("Click for JS Confirm")){
                alertButton.click();
                driver.switchTo().alert().dismiss();
                
            } else if (buttonText.equals("Click for JS Prompt")) {
                alertButton.click();
                driver.switchTo().alert().sendKeys("Hi");
                driver.switchTo().alert().accept();
            }else{
                System.out.println("None the popup there's");
            }



        }



    }
}
