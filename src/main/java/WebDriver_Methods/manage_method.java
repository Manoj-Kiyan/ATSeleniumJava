package WebDriver_Methods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.edge.EdgeDriver;

public class manage_method {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.edge.driver","./drivers/msedgedriver.exe");
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.instagram.com");


        //minimize the browser window :
        driver.manage().window().minimize();


        Thread.sleep(2000);

        //maximize the browser window :
        driver.manage().window().maximize();


        Thread.sleep(2000);

        //fullscreen the browser window :
        driver.manage().window().fullscreen();


        Thread.sleep(2000);

        Dimension size = driver.manage().window().getSize();
        System.out.println(size);
        System.out.println("The height of the browser windows is :" +size.height);
        System.out.println("The width of the browser windows is :" +size.width);
        System.out.println("The height of the browser windows is :"+size.getHeight());


    }
}
