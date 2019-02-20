package Elements;

import Utilities.Mylibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class elemnts {
    public static void main(String[] args) {
        System.out.println("Hello World");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.facebook.com");
        Mylibrary.sleep(3);
        // 8 ways to create elemnts:
        //      xpath, id, name, classname, css, tagname, linktext, partialLinktext.

            //1. xpath:
        // absoulute xpath:  it's the complete path location of the element (in HTML).

        // relative xpath:
                // how to write it:

       String Expected="<input type=\"text\" class=\"inputtext _58mg _5dba _2ph-\" data-type=\"text\" " +
               "name=\"firstname\" aria-required=\"true\" placeholder=\"\" aria-label=\"First name\" id=\"u_0_n\" style=\"\">";


            //    .//tagname[@HTMLelemnt='value' and @HTMLelemnt='vale' ....]
              By firstname =By.xpath(".//input[@type='text' and @name='firstname']");
                  WebElement FirstName=driver.findElement(firstname);

         //    .//input[@name='lastname']
                WebElement LastName=driver.findElement(By.xpath(".//input[@name='lastname']"));


       // ID:
                WebElement clickButton=driver.findElement(By.id("u_0_2"));



        //  Name:
            WebElement LastName2=driver.findElement(By.name("lastname"));
         //    LastName2.sendKeys("yyyyy");

        //classname:

//            WebElement Lastname3=driver.findElement(By.className("inputtext _58mg _5dba _2ph-"));
      //      Lastname3.sendKeys("xxxxxxxxxx");

        //css:
   //     WebElement LastName4=driver.findElement(By.cssSelector("#u_0_p"));
    //    LastName4.sendKeys("iiiiiiiii");
          //          Do Not Use CSS

        // TagName:
        List<WebElement> alllinks=driver.findElements(By.tagName("a"));
        System.out.println(alllinks.size());

        for(WebElement each: alllinks){
            String AA=each.getText();
            if(AA.contains("Find Fri")){
                each.click();

            }
        }
    }

}
