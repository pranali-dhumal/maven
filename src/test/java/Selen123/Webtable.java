package Selen123;

import org.testng.annotations.Test;


	import java.util.List;

	 

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	 

	import io.github.bonigarcia.wdm.WebDriverManager;

	 

	public class Webtable {

	 

	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	            
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
	        driver.findElement(By.id("btnLogin")).click();
	        WebElement Admin = driver.findElement(By.xpath("//b[contains(text(),'Admin')]"));
	        Actions action = new Actions(driver);
	        action.moveToElement(Admin).build().perform();

	 

	        WebElement usermanagement = driver.findElement(By.linkText("User Management"));
	        action.moveToElement(usermanagement).build().perform();

	 

	        driver.findElement(By.linkText("Users")).click();
	        
	        List<WebElement> rows=driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));
	        
	        System.out.println(rows.size());
	        
	        List<WebElement> cols=driver.findElements(By.xpath("//*[@id='resultTable']/thead/tr/th"));
	        
	        System.out.println(cols.size());
	        
	        for(int r=1;r<=rows.size();r++)
	        {
	            for(int c=2;c<cols.size();c++)
	            {
	            System.out.print(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + r + "]/td[" + c + "]")).getText());
	            System.out.print("|");
	            }
	            System.out.println();
	        }
	        
	        System.out.println("--End--");
	    } 

	 

	}