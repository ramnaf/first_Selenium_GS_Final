package HTML_Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SimpleReport {

    public static void main(String[] args) {


        ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("Reports/report1.html");
        //as soon as we create a html reporter we will need to write file location and file name,
        //report1 file will automatically create after executing the code

        ExtentReports myreports = new ExtentReports();//it's the one it generated the report.
        // we are creating a report document and we are attaching the file to it
       //each extentreports only report one own extenttest
        myreports.attachReporter(htmlReporter);

        ExtentTest myTest = myreports.createTest("LogIn Functionality");

        myTest.log(Status.INFO,"Using sysout to print my name");//this is indicating the the test steps
        myTest.log(Status.FAIL,"Invalid Website");
        myTest.log(Status.SKIP,"Previous test failed");
        myTest.log(Status.ERROR,"There has been erros");
        myTest.log(Status.PASS,"This test passed");

        System.out.println("Muhtar Mahmut");

        myreports.setSystemInfo("Browser","www.yahoo.com"); //it allows us to give the information to dashboard
        myreports.setSystemInfo("UserName","tester");
        myreports.setSystemInfo("Password","admin");
        myreports.setSystemInfo("Address","Virginia");

        //we must refresh my report else it will not give html file
        myreports.flush();


        ExtentTest myTest2 = myreports.createTest("LOG Off Functionality");

        myTest2.log(Status.INFO,"logging in");
        System.out.println("loged in");
        myTest2.log(Status.INFO,"logging out");
        System.out.println("loged out");
        myTest2.log(Status.INFO,"Quite the browser");
        System.out.println("Closed the browser");
        myreports.setSystemInfo("website for test 2 ","facebook.com");
        myreports.setSystemInfo("Facebook user name ","Tester");
        myreports.setSystemInfo("Facebook password","Admin");

        myreports.flush(); //to make report file occur




    }
}
