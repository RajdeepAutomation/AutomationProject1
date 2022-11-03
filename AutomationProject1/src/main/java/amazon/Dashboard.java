package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	
	//Step 1 Variable declaration
	
	@FindBy (xpath="(//a[@class='nav-a  '])[1]")
	private WebElement fresh;
	
	@FindBy (xpath="//a[@class='nav-a nav-a-2 nav-progressive-attribute']")
	private WebElement cart;
	
	
	//Step 2 Variable Initialization
	
	public Dashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Step 3 method creation
	
	public void checkfresh() {
		fresh.click();
	}
	
	public void checkcart() {
		cart.click();
	}
	
	

}
