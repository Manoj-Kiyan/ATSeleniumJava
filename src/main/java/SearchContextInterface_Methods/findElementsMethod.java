package SearchContextInterface_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class findElementsMethod {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");

        Thread.sleep(2000);

        //ClassName  tagName  partialLinkText CssSelector  Xpath
        List<WebElement> atag = driver.findElements(By.tagName("a"));
        List<WebElement> divtag = driver.findElements(By.cssSelector("div"));
        List<WebElement> imgtag = driver.findElements(By.xpath("//img"));


        //Print How many atag are present
        System.out.println("The Anchor tag present in the webpage is :"+atag.size());
        System.out.println("The  div tag present in the webpage is :"+divtag.size());
        System.out.println("The  image tag present in the webpage is :"+imgtag.size());

        int countAtag=0;
        int countdivTag=0;
        int countimgTag=0;
        //print text of all Anchor tag
        System.out.println("The Text Present in the Atag are :");
        for (int i = 0; i < atag.size(); i++) {

            //System.out.println(atag.get(i));
            //WebElement link = atag.get(i);
           // System.out.println(link.getText());
//            Write in single line
//             System.out.println(atag.get(i).getText());
            if(!atag.get(i).getText().isEmpty()){
                System.out.println(i+". "+atag.get(i).getText());
                countAtag++;
            }
        }
        System.out.println("Total number of text in the Atag are :"+countAtag);

        System.out.println(" ");



        //print text of all div tag
        System.out.println("The Text Present in the div tag are :");
        for (int i = 0; i < divtag.size(); i++) {

//            WebElement link = divtag.get(i);
//            System.out.println(link.getText());

            if(!divtag.get(i).getText().isEmpty()){
                System.out.println(i+". "+divtag.get(i).getText());
                countdivTag++;
            }
        }
        System.out.println("Total number of text in the Atag are :"+countdivTag);

        System.out.println(" ");




        //print text of image atag
        System.out.println("The Text Present in the image tag are :");
        for (int i = 0; i < imgtag.size(); i++) {
//            WebElement link = imgtag.get(i);
//            System.out.println(link.getText());
                String ex= atag.get(i).getText();
                if(!ex.isEmpty()){
                    System.out.println(i+". "+ex);
                    countimgTag++;
                }

        }
        System.out.println("Total number of text in the Atag are :"+countimgTag);

        driver.quit();
    }
}
