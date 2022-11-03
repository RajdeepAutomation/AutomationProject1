package zerodha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login1 {
	
	// Step 1 To declare the global variable (Data Member)
	
	
      @FindBy (xpath="//input[@type='text']")
      private WebElement username;
      
      @FindBy (xpath="//input[@type='password']")
  	  private WebElement password;
      
      @FindBy (xpath="//button[@type='submit']")
  	  private WebElement loginButton;
      
   // Step 2 Initialization of variable
 
      public Login1(WebDriver driver) {
    	  PageFactory.initElements(driver, this);
      }
      
   // Step 3 Method create
		
   		public void enterUN() {
   			username.sendKeys("OKP335");
   		}

   		public void enterPWD() {
			password.sendKeys("ZAQ1234567");
		}

   		public void login() {
			loginButton.click();
		}


}
