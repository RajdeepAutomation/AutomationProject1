package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {
	
	//Step 1 Declare global variable
	
	@FindBy (xpath="//input[@type='email']")
	private WebElement username;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement conti;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement passward;
	
	@FindBy (xpath="//input[@id='signInSubmit']")
	private WebElement submit;
	
	
	//Step 2 Variable initialization
	
	public SignIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//Step 3 Method Creation
	
	public void enterUN() {
		username.sendKeys("9423263109");
	}
	
	public void clickcontinue() {
		conti.click();
	}
	
	public void enterPass() {
		passward.sendKeys("rutuja5713");
	}
	
	public void clicksubmit() {
		submit.click();
	}
	
}
