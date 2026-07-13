package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class idlocator {
    public static void main(String[] args) throws  Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        Thread.sleep(2000);

        By id = By.id("_R_64mkqsr9pb6amH1_");
        WebElement emailTF = driver.findElement(id);

        emailTF.sendKeys("manojkiyan23032004@gmail.com");
        //OR

        // driver.findElement(By.id("_R_64mkqsr9pb6amH1_")).sendKeys("manojkiyan23032004@gmail.com");
            //--> sendkeys return type is void so, no need to return type and non primitive

        Thread.sleep(2000);

        By id2 = By.id("_R_66mkqsr9pb6amH1_");

        WebElement passTF = driver.findElement(id2);

        passTF.sendKeys("Manoj2316@");

        //driver.findElement(By.id("_R_66mkqsr9pb6amH1_")).sendKeys("Manoj2316@");

        Thread.sleep(2000);

        //By clsName =By.className("");
        By loginbutton = By.xpath("//*[@id=\"login_form\"]/div/div[1]/div/div[3]/div/div");
        WebElement logButton = driver.findElement(loginbutton);
        logButton.click();



    }
}
