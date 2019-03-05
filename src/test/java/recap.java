import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class recap {

    //why use testng ? as soon as one setep failed in java file all other step cannt exucute  but in testng
    // it has after method after class they can run without effecting by fail test

    //extentreport only reports extent test

    //how to create html report in java ?
    // step1.create a extent report document

    public static void main(String[] args) {

        ExtentReports reportdocument=new ExtentReports();
        ExtentHtmlReporter htmlFile=new ExtentHtmlReporter("test-output/Kuddus.html");
        reportdocument.attachReporter(htmlFile);

        ExtentTest Tests = reportdocument.createTest("Testing the log in functionality");
     //extent report only can test own created test this  test is test cases
        Tests.info("open browser, go to website");//test detail, step definiton on the report htmlfile
        System.out.println("Go to Web");

        Tests.log(Status.INFO,"Logging in");
        System.out.println("Log in");

        Tests.log(Status.INFO,"Logging out"); //test detail, step definiton on the report htmlfile
        System.out.println("Log out");

        Tests.info("Quite the browser");
        System.out.println("Close the browser");

        reportdocument.setSystemInfo("Website","www.facebook.com");
        reportdocument.setSystemInfo("UserName","Tester");
        reportdocument.setSystemInfo("PassWord","Admin");

        htmlFile.config().setDocumentTitle("Facebook LogIn");
        htmlFile.config().setReportName("Mirzat GOAT");
        htmlFile.config().setTheme(Theme.DARK);

        reportdocument.flush();
    }
}



