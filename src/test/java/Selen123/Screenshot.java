package Selen123;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
  @Test
  public void sshot() throws InterruptedException, Exception {
	  WebDriverManager.chromedriver().setup();
      

	  ChromeDriver driver = new ChromeDriver();
      driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
       
      
      
 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(src, new File("C:\\screenshot\\Appscreenshot.png"));
         
  }
  }

