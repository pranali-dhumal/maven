package Selen123;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Data1 {

  @DataProvider(name="Login")
  public Object[] getData()
  {
      Object[] data = {"Admin","temp"};
      return data;
  }
  @DataProvider(name = "Login")
  public Object[][] getDataforLoginDifferentScenarios() {
      return new Object[][] { 
              { "admin", "", "Password cannot be empty"},
              { "", "admin123", "Username cannot be empty" }, 
              { "AdminWrong", "admin123", "Invalid credentials" },
              { "admin", "admin", "Invalid credentials" }, 
              { "admin", "admin123", "Dashboard" } };



  }
  }

