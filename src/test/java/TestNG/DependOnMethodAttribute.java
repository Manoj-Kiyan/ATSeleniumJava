package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependOnMethodAttribute {
    @Test
    public void test1() {
        System.out.println("TestNG Working");
    }
    @Test(dependsOnMethods = "test1" )
    public  void registerTest(){
        Reporter.log("Register test case pass");
    }

    @Test(dependsOnMethods = {"test","registerTest"})
    public void loginTest(){
        Reporter.log("Hi MK Login Success ! . . .",true);
    }

    @Test(dependsOnMethods = {"test","registerTest","loginTest"})
    public void purchase(){
        Reporter.log("Purchase Successful MK !");
    }

}
