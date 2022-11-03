package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteFromCart {
	
	//Step 1 Variable declaration
	
		@FindBy (xpath="//a[@class='nav-a nav-a-2 nav-progressive-attribute']")
		private WebElement cart;
		
		@FindBy (xpath="(//input[@value='Delete'])[1]")
		private WebElement delete;
		
		//Step 2 Variable Initialization
		
		public DeleteFromCart(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Step 3 method creation
		
	
		public void removecart() throws InterruptedException {
			cart.click();
			
			Thread.sleep(5000);
			
	         delete.click();
		}
		
	

}
