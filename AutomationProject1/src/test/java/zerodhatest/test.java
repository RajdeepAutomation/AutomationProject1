package zerodhatest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import zerodha.Home;
import zerodha.Login1;
import zerodha.Login2;

public class test {
	
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\RJ\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
	
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://kite.zerodha.com/");
		
        Login1 log = new Login1(driver);
		
		log.enterUN();
		log.enterPWD();
		log.login();
		
		Login2 log1 = new Login2(driver);
		Thread.sleep(5000);
		
		log1.enterpin();
		log1.clicksubmit();
		
		Home hm = new Home(driver);
		hm.order();
	

}
}