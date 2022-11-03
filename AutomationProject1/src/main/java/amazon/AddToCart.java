package amazon;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
	
	//Step 1 Variable declaration
	
		@FindBy (xpath="//input[@id='twotabsearchtextbox']")
		private WebElement input;
		
		@FindBy (xpath="//input[@id='nav-search-submit-button']")
		private WebElement search;
		
		@FindBy (xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")
		private WebElement redmi9;
		
		@FindBy (xpath="//input[@id='add-to-cart-button']")
		private WebElement atc;
		
		
		//Step 2 Variable Initialization
		
		public AddToCart(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Step 3 method creation
		
		public void searchtab() {
			input.sendKeys("mobile");
		}
		
		public void searching() {
			search.click();
		}
		
		public void clikonredmi() {
			redmi9.click();
		}
		
		public void adding(WebDriver driver) throws InterruptedException {
			
			Set<String> ids = driver.getWindowHandles();
			
			ArrayList<String> a1 = new ArrayList<String>(ids);
			
			String cwid = a1.get(1);
			
			driver.switchTo().window(cwid);
			
			Thread.sleep(3000);
			
			atc.click();
			
			Thread.sleep(5000);
			
			driver.close();
			
			driver.switchTo().window(a1.get(0));
			
			Thread.sleep(2000);
		}
	

}
