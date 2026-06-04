package Locators.Xpath.RelativeXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathByAxes {

    public static void main(String[] args) throws Exception{

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://gmail.com");

        Thread.sleep(2000);

        driver.findElement(By.id("identifierId")).sendKeys("manojkiyan2303@gmail.com");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Next']/ancestor::div[@class='O1Slxf']/descendant::span[text()='Create account']")).click();
        ////span[text()='Next']/ancestor::div[@class='O1Slxf']/descendant::span[text()='Create account']
        ////span[text()='Next']/ancestor::div[@class='TNTaPb']/following-sibling::div/descendant::span[text()='Create account']
    }
}

//OTHER EXAMPLES:
//Select all siblings after the label       :   //label[@id='user-label']/following-sibling::*
// Select the first sibling (the input)     :   //label[@id='user-label']/following-sibling::input[1]
// Select the second sibling (the span)     :   //label[@id='user-label']/following-sibling::*[2]
// Select a sibling with a specific class   :   //label[@id='user-label']/following-sibling::span[@class='error-msg']
// Chaining axes to reach a distant sibling :   //label[@id='user-label']/following-sibling::input/following-sibling::button