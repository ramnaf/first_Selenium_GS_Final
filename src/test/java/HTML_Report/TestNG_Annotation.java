package HTML_Report;

import org.testng.annotations.*;

public class TestNG_Annotation {

    @BeforeMethod
    public void x1(){
        System.out.println("This is before method");

    }


   @BeforeClass //
   public void x2(){
       System.out.println("This is before class");

   }


    @BeforeSuite  //used for multiple before tests
    public void x3(){
        System.out.println("This is before suite");

    }



    @BeforeTest   // is multiple classes//if we have multiple class wanna report one report you only can use before test
    public void x4(){
        System.out.println("This is before test");

    }

    @Test
    public void x5(){
        System.out.println("This is test");

    }


    @Test
    public void x6(){
        System.out.println("This is test2");

    }


    @AfterMethod
    public void y1(){
        System.out.println("This is after method");

    }


    @AfterClass //
    public void y2(){
        System.out.println("This is after class");

    }


    @AfterSuite  //used for multiple before tests
    public void y3(){
        System.out.println("This is after suite");

    }



    @AfterTest   // is multiple classes//if we have multiple class wanna report one report you only can use before test
    public void y4(){
        System.out.println("This is after test");

    }


}