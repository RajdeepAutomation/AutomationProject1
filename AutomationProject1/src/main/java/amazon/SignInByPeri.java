package amazon;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInByPeri {
	
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
		
		public SignInByPeri(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		
		//Step 3 Method Creation
		
		public void enterUN() throws IOException {
			
			FileInputStream file = new FileInputStream ("C:\\Users\\RJ\\Desktop\\Excelsheet\\account details.xlsx");
			
			String un = WorkbookFactory.create(file).getSheet("Sheet3").getRow(0).getCell(0).getStringCellValue();
			
			username.sendKeys(un);
		}
		
		public void clickcontinue() {
			conti.click();
		}
		
		public void enterPass() throws IOException {
			
			FileInputStream folder = new FileInputStream("C:\\Users\\RJ\\Desktop\\Excelsheet\\account details.xlsx");
		       
			String pw = WorkbookFactory.create(folder).getSheet("Sheet3").getRow(1).getCell(0).getStringCellValue();
			
			passward.sendKeys(pw);
		}
		
		public void clicksubmit() {
			submit.click();
		}
		

}
