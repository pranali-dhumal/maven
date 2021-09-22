package Selen123;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Synchronization {
    public static void main(String args[]) {
    	 WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         
         driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
                
        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
         driver.findElement(By.xpath("//*[@id='start']/button")).click();
        
        //---------------------------------------------------------------
        
       //Explicit Wait - WebDriverWait
         
         
         System.out.println(driver.findElement(By.xpath("//*[@id='finish']/h4")).getText());
         /* 
         driver.findElement(By.xpath("//*[@id='start']/button")).click();
         
         
         WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));    
         
         w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']/h4")));
         
         String str=driver.findElement(By.xpath("//*[@id='finish']/h4")).getText();
         
         System.out.println(str);        
         */
         
         //---------------------------------------------------------------
         
         
         //Explicit Wait - FluentWait
     
         driver.findElement(By.xpath("//*[@id='start']/button")).click();

  

         Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(6))
                 .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

  

         WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>() {

  

             public WebElement apply(WebDriver driver) {
                 if (driver.findElement(By.xpath("//*[@id='finish']/h4")).isDisplayed()) {
                     return driver.findElement(By.xpath("//*[@id='finish']/h4"));
                 } else {
                     return null;
                 }

  

             }
         });

  

         System.out.println(driver.findElement(By.xpath("//*[@id='finish']/h4")).getText());
         
             
     }
}