package Selen123;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class coookies {

	WebDriver driver;

    @Test
    public void actionsOnCookies() {

            WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          //driver.get("https://demoqa.com/webtables");
          driver.get("https://opensource-demo.orangehrmlive.com/");

          Set<Cookie> cookies = driver.manage().getCookies();
          System.out.println("Total cookies:" + cookies.size());

          for(Cookie cookie: cookies)
          {
              System.out.println(cookie.getName() + ":" + cookie.getValue());
          }

          Cookie cookieObj = new Cookie("MyCookie","123456");
          driver.manage().addCookie(cookieObj);

          cookies = driver.manage().getCookies();
          System.out.println("Total cookies after adding one cookie:" + cookies.size());

          for(Cookie cookie: cookies)
          {
              System.out.println(cookie.getName() + ":" + cookie.getValue());
          }

          driver.manage().deleteCookie(cookieObj);
          cookies = driver.manage().getCookies();
          System.out.println("Total cookies after deleting one cookie:" + cookies.size());

          driver.manage().deleteAllCookies();

          driver.close();
    }
}