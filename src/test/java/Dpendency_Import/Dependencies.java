package Dpendency_Import;

import Utilities.Mylibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Dependencies {

    public static void main(String[] args) {

        // set up selenium environment
        WebDriverManager.chromedriver().setup();

        // declare webdriver veariable:
     //   WebDriver driver=new WebDriver();        // WebDriver is an interface.
        WebDriver driver=new ChromeDriver();
           //    driver.get("http://www.facebook.com");          //in side get() must provide String value.
                        // get: waits for the web fully uploaded.

        driver.navigate().to("http://www.facebook.com");
                    // Nevigate Does not wait for the web fully uploaded.
            // Navigate is faster than get.
      Mylibrary.sleep(3);    // Thread.sleep will make the java vertual machine to sleep

        // in order to refresh:
            driver.navigate().refresh();
            new Actions(driver).pause(3000).perform(); // Action.pasue will make time outs for Selenium webdriver.
                // in every actions we must put the .perform() at the end.

            // goback to previous side:
            driver.navigate().back();
        Mylibrary.sleep(3);

            // go forward:ssss
        driver.navigate().forward();
        Mylibrary.sleep(3);

     //   driver.close();   // closes the current tab

        driver.quit();  // quites the webdriver.

    }

}
