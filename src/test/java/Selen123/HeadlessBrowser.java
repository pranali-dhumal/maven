package Selen123;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowser {
 @Test
 public void testheadlessbrowser() throws InterruptedException {


    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();
    options.setHeadless(true);
    options.addArguments("incognito");
    ChromeDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();

    driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    driver.findElement(By.name("txtUsername")).sendKeys("Admin");
    driver.findElement(By.name("txtPassword")).sendKeys("admin123");
    driver.findElement(By.id("btnLogin")).click();
    Thread.sleep(5000);
    System.out.println(driver.getCurrentUrl());
    System.out.println("Dashboard displayed: " + driver.findElement(By.linkText("Dashboard")).isDisplayed());
    driver.quit();
}

}
