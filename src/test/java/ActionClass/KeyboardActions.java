package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KeyboardActions {
    public static void main(String[] args) throws  Exception {

        WebDriver driver =null;


        Thread.sleep(2000);

        // Set ChromeDriver path if not in system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Navigate to a test page with input fields
            driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_test");

            // Switch to iframe containing the input field
            driver.switchTo().frame("iframeResult");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Locate the first input field
            WebElement firstInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.name("fname"))
            );

            // Type some text
            firstInput.sendKeys("Selenium Keyboard Actions Test");

            // Create Actions instance
            Actions actions = new Actions(driver);

            /**
             * In Selenium’s Actions API:
             *
             * keyDown(Keys.CONTROL)
             * → Simulates pressing and holding the Control key (but not releasing it yet).
             * This is like physically holding down the CTRL key on your keyboard.
             *
             * sendKeys("a")
             * → Sends the letter "a" while CTRL is still being held down.
             * This combination triggers the OS/browser shortcut CTRL+A (Select All).
             *
             * keyUp(Keys.CONTROL)
             * → Simulates releasing the Control key.
             * Without this, Selenium would think CTRL is still pressed for future actions.
             **/


            // CTRL + A (Select All)
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
            Thread.sleep(500); // small pause for visibility

            // CTRL + C (Copy)
            actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
            Thread.sleep(500);

            // Locate the second input field
            WebElement lastInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.name("lname"))
            );

            // Click into second field
            lastInput.click();

            // CTRL + V (Paste)
            actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
            Thread.sleep(1000);

            System.out.println("✅ Keyboard actions completed successfully!");

        } catch (Exception e) {
            System.err.println("❌ Error during execution: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }


    }
}


