package amazontest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.Dashboard;
import amazon.MoveToSignIn;
import amazon.SignInByPeri;
import amazon.SignOut;

public class TsstSignInbyPeri {
	
	MoveToSignIn ms;
	SignInByPeri sip;
	Dashboard db;
	SignOut so;
	WebDriver driver;
	
	@BeforeClass
	public void openapp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\RJ\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ms = new MoveToSignIn(driver);
	    ms.move(driver);
	}

   @BeforeMethod
   public void signintoapp() throws IOException {
	   System.out.println("Before method");
	   sip = new SignInByPeri(driver);
	   sip.enterUN();
	   sip.clickcontinue();
	   sip.enterPass();
	   sip.clicksubmit();
	   
	 
	   
	   db = new Dashboard(driver);
	   so = new SignOut(driver);
	   
	   
   }
   
   @Test
   public void test1() {
	   System.out.println("Test 1");
	   db.checkfresh();
   }
   
   @Test
   public void test2() {
	   System.out.println("Test 2");
	   
	   db.checkcart();
   }
   
  @AfterMethod
  
  public void abc() {
	  System.out.println("After Method");
	  so.getsignout(driver);
  }
  
   @AfterClass
   public void afterclass() {
	   
	   driver.close();
   }

	

}
