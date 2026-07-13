package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PriorityTest {

    @Test(priority = -1)
    public void test1() {
        System.out.println("TestNG Working");
    }
    @Test
    public  void registerTest(){
        Reporter.log("Resiter test case pass");
    }

    @Test
    public void loginTest(){
        Reporter.log("Hi MK Login Success ! . . .",true);
    }

    @Test
    public void purchase(){
        Reporter.log("Purchase Succesfull MK !");
    }



}