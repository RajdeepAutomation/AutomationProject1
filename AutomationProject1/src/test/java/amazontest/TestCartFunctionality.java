package amazontest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import amazon.AddToCart;
import amazon.DeleteFromCart;
import amazon.MoveToSignIn;
import amazon.SignIn;
import amazon.SignOut;

public class TestCartFunctionality {
	
	MoveToSignIn ms;
	SignIn si;
	SignOut so;
	AddToCart ac;
	DeleteFromCart dc;
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
   public void signintoapp() {
	   System.out.println("Before method");
	 
	   si = new SignIn(driver);
	   
	   si.enterUN();
	   si.clickcontinue();
	   si.enterPass();
	   si.clicksubmit();
	   
	
	   so = new SignOut(driver);
	   ac = new AddToCart(driver);
	   dc = new DeleteFromCart(driver);
	   
   }
   
   @Test
   public void test1() throws InterruptedException {
	   System.out.println("Test 1");
	   
	   ac.searchtab();
	   ac.searching();
	   ac.clikonredmi();
	   ac.adding(driver);
	   
	   String url = driver.getCurrentUrl();
	   String title = driver.getTitle();
	   
	   SoftAssert soft = new SoftAssert();
	   
	   soft.assertEquals(url, "https://www.amazon.in/cart/smart-wagon?newItems=Cb265b542-aa07-4890-8c0d-20f395fe3007,1");
	   soft.assertEquals(title, "Amazon.in Shopping Cart");
	    
   }
   
   @Test
   public void test2() throws InterruptedException {
	   System.out.println("Test 2");
	   
	   dc.removecart();
	
   }
   
  @AfterMethod
  
  public void abc() {
	  so.getsignout(driver);
  }
  
   @AfterClass
   public void afterclass() {
	   
	   driver.close();
   }

}
