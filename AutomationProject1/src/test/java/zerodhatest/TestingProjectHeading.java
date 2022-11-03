package zerodhatest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import zerodha.Home;
import zerodha.Login1;
import zerodha.Login2;
import zerodha.Logout;

public class TestingProjectHeading {
	
	WebDriver driver;
    Login2 loginpin;
    Home home;
    Logout logout;
	
	@BeforeClass
	public void openbrowser() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\RJ\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//ChromeOptions opt = new ChromeOptions();
		//pt.addArguments("--disable-notifications");
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://kite.zerodha.com/");
		
	}
	
	@BeforeMethod
	public void logintoApplication() throws InterruptedException {
		System.out.println("Before Method");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://kite.zerodha.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Login1 log = new Login1(driver);
		Thread.sleep(5000);
		log.enterUN();
		log.enterPWD();
		log.login();
		
		loginpin = new Login2(driver);
		Thread.sleep(5000);
		loginpin.enterpin();
		loginpin.clicksubmit();
		
		home = new Home(driver);
		logout = new Logout(driver);
		
	}

	@Test
	public void test() {
		System.out.println("Test");
		home.order();
		String url =driver.getCurrentUrl();
		if(url.equals("https://kite.zerodha.com/orders")) {
			System.out.println("Test Case Pass");
		}
		else {
			System.out.println("Test case Fail");
		}
		
	}
	
	@Test
	public void test1() {
		System.out.println("Test1");
		home.holdings();;
		String url =driver.getCurrentUrl();
		if(url.equals("https://kite.zerodha.com/holdings")) {
			System.out.println("Test Case Pass");
		}
		else {
			System.out.println("Test case Fail");
		}
		
	}
	
	@Test
	public void test2() {
		
		System.out.println("Test2");
		home.positions();
		String url =driver.getCurrentUrl();
		if(url.equals("https://kite.zerodha.com/positions")) {
			System.out.println("Test Case Pass");
		}
		else {
			System.out.println("Test case Fail");
		}
	}
	
	
	@AfterMethod
	public void logout() throws InterruptedException {
		System.out.println("After Method");
		
		home.logout();
		logout.clickuser();
	}
	
	@AfterClass
	public void afterclass() {
		driver.close();
	}
	
}
