package TestNG;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;


public class Listeners_Implementations implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);

        TakesScreenshot ts = (TakesScreenshot)Listeners_Learning.driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);

        File dir = new File("./src/test/java/TakesScreenShot_Interface/screenshots");
        File file = new File(dir,"DMWS2_"+result.getName()+".png");

        try {
            FileHandler.copy(screenshot,file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
