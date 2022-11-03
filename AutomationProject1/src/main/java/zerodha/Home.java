package zerodha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	// Step 1 To declare the global variable (Data Member)
	
	@FindBy (xpath="//span[text()='Orders']")
	private WebElement orders;
	
	@FindBy (xpath="//span[text()='Holdings']")
	private WebElement holdings;
	
	@FindBy (xpath="//span[text()='Positions']")
	private WebElement position;
	
	@FindBy (xpath="//span[@class='user-id']")
	private WebElement profileName;
	
	@FindBy (xpath="//a[@target='_self']")
	private WebElement logout1;
	

	// Step 2 Initialization of variable
	
			public Home(WebDriver driver) {
					
			PageFactory.initElements(driver, this);
		}
    
	// Step 3 Method create
			
			public void order() {
			   orders.click();
		}
			
			public void holdings() {
				holdings.click();
			}
			
			public void positions() {
				position.click();
			}
			
			public void logout() throws InterruptedException {
				profileName.click();
				Thread.sleep(2000);
				logout1.click();
			}
					
		
}
