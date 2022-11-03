package amazontest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import amazon.Dashboard;
import amazon.MoveToSignIn;
import amazon.SignIn;
import amazon.SignOut;

public class TestAmazon {
	MoveToSignIn ms;
	SignIn si;
	Dashboard db;
	SignOut so;
	WebDriver driver;
	
	@Parameters("browser")
	
	@BeforeTest
	public void openbrowser(String browsername) {
		
		System.out.println(browsername);
		
		if(browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\RJ\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		if(browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\RJ\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
	}
	
	@BeforeClass
	public void openapp() throws InterruptedException {
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ms = new MoveToSignIn(driver);
	    ms.move(driver);
	    si = new SignIn(driver);
	    db = new Dashboard(driver);
		so = new SignOut(driver);
	}

   @BeforeMethod
   public void signintoapp() {
	   System.out.println("Before method");
	
	   si.enterUN();
	   si.clickcontinue();
	   si.enterPass();
	   si.clicksubmit();  
   }
   
   @Test
   public void test1() {
	   System.out.println("Test 1");
	   db.checkfresh();
	   String url = driver.getCurrentUrl();
	  String title = driver.getTitle();
	  
	  Assert.assertEquals(url, "https://www.amazon.in/alm/storefront?almBrandId=ctnow&ref_=nav_cs_fresh");
	  Assert.assertEquals(title, "Amazon.in: Amazon Fresh");
   }
   
   @Test
   public void test2() {
	   System.out.println("Test 2");
	   
	   db.checkcart();
	   
	   String url = driver.getCurrentUrl();
	   String title = driver.getTitle();
		  
      Assert.assertEquals(url, "https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
	  Assert.assertEquals(title, "Amazon.in Shopping Cart");
   }
   
  @AfterMethod
  
  public void abc() {
	  so.getsignout(driver);
  }
  
 
   @AfterClass
   public void afterclass() {
	   ms = null;
	   si = null;
	   db = null;
	   so = null;
	   
   }
   @AfterTest
   
   public void closing() {
 	 
 	   driver.close();
 	   System.gc();
 	   driver = null;
   }
   
}
