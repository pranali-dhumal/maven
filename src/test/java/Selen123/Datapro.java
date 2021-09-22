package Selen123;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Datapro {
    WebDriver driver;

 

    
    @Test(dataProvider="Login", dataProviderClass=Datapro.class)
    
        public void OrangeHRM_Login(String uname,String upass)throws InterruptedException {
        WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            System.out.println(uname);
            driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
            driver.findElement(By.name("txtUsername")).clear();
            driver.findElement(By.name("txtUsername")).sendKeys(uname);
            driver.findElement(By.name("txtPassword")).clear();
            driver.findElement(By.name("txtPassword")).sendKeys("admin123");
            driver.findElement(By.id("btnLogin")).click();
            System.out.println(driver.findElement(By.linkText("Dashboard")).isDisplayed());
            driver.close();
    } 
    @BeforeTest
    public void LaunchBrowser() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    	
    }
    @AfterTest
    public void CloseBrowser() {
    	driver.close();
    }
  

}
