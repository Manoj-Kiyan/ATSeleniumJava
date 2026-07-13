package WebElementInterface_Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getDomAttribute {

    public static void main(String[] args) throws  Exception {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");

        Thread.sleep(2000);
    }
}
/*
<input id="username" type="text" value="htmlvalue">
Initial HTML: value="htmlvalue"

User types "newUser"

Method	Output
getAttribute("value")	May return "htmlvalue" or "newUser" depending on browser (inconsistent).
getDomAttribute("value")	Always "htmlvalue" (original HTML).
getDomProperty("value")	"newUser" (current DOM state).
 */