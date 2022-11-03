package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOut {

	
	//Step 1 variable declaration
	
	@FindBy (xpath="//a[@class='nav-a nav-a-2 nav-truncate   nav-progressive-attribute']")
	private WebElement exit;
	
	@FindBy (xpath="(//span[@class='nav-text'])[18]")
	private WebElement sout;
	
	
	//Step 2 variable initialization
	
	public SignOut(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Step 3 method creation
	
	public void getsignout(WebDriver driver) {
		
		
		Actions s = new Actions(driver);
	    s.moveToElement(exit).build().perform();
		s.moveToElement(sout).click().build().perform();
		
	}

}
