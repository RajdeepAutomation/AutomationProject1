package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoveToSignIn {
	
	//Step 1 To declare global variable
	
	@FindBy (xpath="(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]")
	private WebElement src;
	
	@FindBy (xpath="(//span[@class='nav-action-inner'])[1]")
	private WebElement des;
	
     
	
	// Step 2 initialization of variables
	
	public MoveToSignIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//Step 3 Method creation
	
	public void move(WebDriver driver) {
		
		Actions a = new Actions(driver);
		a.moveToElement(src).moveToElement(des).click().perform();
		
		
		
		
		
	}

}
