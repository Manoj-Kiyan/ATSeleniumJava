package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class scrollAction {

    public static void main(String[] args) throws  Exception {

        WebDriver driver = new ChromeDriver();

        driver .manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");

        Thread.sleep(2000);



        Actions action = new Actions(driver);


        WebElement atc = driver.findElement(By.xpath("(//input[@value='Add to cart'])[2]"));

        action.scrollToElement(atc).perform();

        Thread.sleep(2000);

        WebElement price = driver.findElement(By.xpath("(//span[@class='price actual-price'])[2]"));
        action.click(price).clickAndHold(price).doubleClick(price).perform();

        Thread.sleep(3000);

        //action.scrollByAmount(0,-400);

        WebElement scrollUptoRegister = driver.findElement(By.linkText("Register"));
        action.scrollToElement(scrollUptoRegister).perform();





    }
}
