package zerodha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	
	@FindBy (xpath="//[text()='Change user']")
	private WebElement changeuser;
	
	public Logout (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickuser() {
		changeuser.click();
	}
	

}
