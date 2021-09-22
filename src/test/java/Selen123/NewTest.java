package Selen123;



 import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class NewTest {
	@Test
	public void login() {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
         String str = driver.findElement(By.id("txtUsername")).getAttribute("Admin");
         System.out.println(str);
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@class='button']")).click();
       
	}
	



	}

