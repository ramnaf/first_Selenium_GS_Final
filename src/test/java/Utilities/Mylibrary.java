package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.util.List;



public class Mylibrary {


    public static Actions act;

    public static void sleep(double a) {
        try {
            Thread.sleep((int) (a * 1000));
        } catch (InterruptedException e) {

        }
    }

    public static void ClickDynamic(WebDriver driver, String codition) {
        List<WebElement> allclickable = driver.findElements(By.tagName("a"));
        for (WebElement each : allclickable) {
            if (each.getText().contains(codition)) {
                each.click();
                Mylibrary.sleep(3);
                break;
            }
        }
    }

    public static void TakeScreenshotsplease(WebDriver driver, String SaveAs) {
        TakesScreenshot mirzat = (TakesScreenshot) driver;
        File myfile = mirzat.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(myfile, new File("src/test/captures/" + SaveAs + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void scrollplease(WebDriver driver,int y){
        JavascriptExecutor mm=(JavascriptExecutor)driver;
        mm.executeScript("scroll(0,"+y+")");




    }

    public  static void waittitle(WebDriverWait wait, String titleContains){
        wait.until(ExpectedConditions.titleContains(titleContains));
    }

}