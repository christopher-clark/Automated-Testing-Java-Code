import java.awt.List;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class XPathPage {

	WebDriver driver;
	
	public XPathPage(WebDriver driver){
		this.driver = driver;
	}
	@FindBy(id="username") 
	@CacheLookup
	WebElement username;
	
	@FindBy(id="selectCurrency")
	WebElement currencySelector;
	
	@FindBy(name="selectCurrency")
	WebElement currencyDropdown;
	
	ArrayList<WebElement> currencies = new ArrayList<WebElement>();
		
	public void viewCurrencies(){
		currencySelector.click();
		// Cast WebElement into a Select before use !!!!
		
	}
	public void selectCurrency(String value){
		Select curr = new Select(currencyDropdown);
		curr.selectByValue(value);
	}
	
	public void closeBrowser(){
		driver.quit();
	}
}
