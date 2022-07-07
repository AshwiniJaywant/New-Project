package Test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Base.Base_Class;
import Pom.Home;
import Pom.Login;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Test_Class {
	
  ExtentReports reports;
	ExtentTest test;
	
	WebDriver driver;
	Login LP;
	Home HP;
	
 @Parameters("browser")
  @BeforeClass
  public void beforeClass(String k) {
        driver=Base_Class.getDriver(k);
  }	
  
  @BeforeMethod
  public void beforeMethod() {
	  LP=new Login(driver);
	  HP=new Home(driver);
  }
  
  @Test(priority=0)
  public void verifyUserCanLogin() throws IOException {
	  LP.putEmail();
	  LP.putPassword();
	  LP.clickSubmitBtn();
	  LP.enterPin();
  }
  @Test
  public void verifyUserCanAddFund() throws IOException
  {
  HP.clickIcon();
  Assert.assertTrue(HP.verifyUserValidateProfile());
  HP.clickFundButton();
  }
  @AfterMethod
  public void afterMethod() {
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
