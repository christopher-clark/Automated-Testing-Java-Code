import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	@FindBy(how= How.ID, using = "")
	WebElement City;
	
	@FindBy(how = How.ID, using="")
	WebElement Hotel;

	@FindBy(how= How.ID, using = "")
	WebElement CheckinDate;
	
	@FindBy(how= How.ID, using = "")
	WebElement CheckoutDate;
	
	@FindBy(how=How.ID, using ="")
	WebElement NumberOfPeople;
	
	@FindBy(how=How.NAME,using ="q")
	WebElement Search;
	
	public HomePage() {
		// TODO Auto-generated constructor stub
	}
	
	public void googleSearch(String value)
	{
		Search.sendKeys(value);
		Search.submit();
		webElementSync(value);
	}
		
	public void bookingSearch(String city, String hotel, String checkindate, String checkoutdate, String numpeople)
	{
		City.sendKeys(city);
		Hotel.sendKeys(hotel);
		CheckinDate.sendKeys(checkindate);
		CheckoutDate.sendKeys(checkoutdate);
		NumberOfPeople.sendKeys(numpeople);
		//webElementSync(value);
		
	}

}
