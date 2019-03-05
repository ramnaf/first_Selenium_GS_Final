package HTML_Report;

import Utilities.Mylibrary;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_ReportFull {
        //Instance variable are created here so we can used outside method
        ExtentReports ReportDoc; //only runs ones in whole test
        ExtentHtmlReporter File;
        ExtentTest Test;
        WebDriver driver;
        //this is testNG report we are creating html file for failed tests

    @BeforeClass   //chcek whole class only excute one time
       public void BC(){
        //document and html will only creates once in each class
        //in order to generate html report first we need to create extent report, and it represent the document
        ReportDoc = new ExtentReports();
        //then we need to create html report file
        File = new ExtentHtmlReporter("Reports/Facebooks.html");
        //then we have to attach reportfile to html
        ReportDoc.attachReporter(File);
    }
    @AfterMethod
        public void AA(ITestResult result){//its nolonger user provide its console provide
            //ITestResult indicates the test result for us and looks at the concel
            if(result.getStatus() == ITestResult.SUCCESS){
                System.out.println("Your test is passed");
                Test.log(Status.PASS,"Sucessfully passed");
                //we must indicate the info in every single step when we test in order to get the report
                //below is a step definition

            }else if(result.getStatus()==ITestResult.FAILURE ){
                System.out.println("Your test is failed, plz read the report");
                Test.log(Status.FAIL,"Your test is failed");
                Test.log(Status.FAIL, result.getThrowable());
                Mylibrary.TakeScreenshotsplease(driver,result.getName());
                Test.addScreenCaptureFromBase64String("src/test/captures/" +result.getName() +".png");

            }else if(result.getStatus() == ITestResult.SKIP){
                System.out.println("Some tests has skipped");
                Test.log(Status.SKIP,"Test has been skipped");
            }
        }

        @Test
        public void verifyFaceBook(){
            //since extent report only reports extent test,
            //there for in each we have to create extent test in the report document
            Test = ReportDoc.createTest("Verify Facebook Page");
            //extent test will created once in every test
            //each test steps we have to address in extents test, so it can present in details
            Test.log(Status.INFO,"Set up chrome driver");
            WebDriverManager.chromedriver().setup();
            Test.info("Create Webdriver");
             driver = new ChromeDriver();
            Test.info("Open Html");
            driver.navigate().to("htt//www.facebook.com");

        }

        @AfterTest
        public void AF(){
            File.config().setDocumentTitle("Facebook Report");
            File.config().setReportName("girls who code");
            File.config().setTheme(Theme.DARK);
            ReportDoc.setSystemInfo("Website", "facebook");
            ReportDoc.setSystemInfo("username", "ramnaf");
            ReportDoc.setSystemInfo("password", "mila");
            ReportDoc.flush();

        }

        @Test
        public void Test2(){
        Test=ReportDoc.createTest("Test 2");
        Test.log(Status.INFO,"Seeting up environemnt");
        WebDriverManager.chromedriver().setup();
        Test.info("web-driver");
        WebDriver driver=new ChromeDriver();
        Test.info("go to URL");
        driver.navigate().to("https://www.facebook.com");

    }

    }
