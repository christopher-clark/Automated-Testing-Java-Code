import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BookHotel {
	private WebDriver driver;
	private WebElement searchField;
	private String winHandleBefore;
			
	public static void main(String[] args){
		String destination = "London England";
		BookHotel bookHotel = new BookHotel();
		bookHotel.startBrowser();
		// Adding a comment
		bookHotel.clearSearch();
		bookHotel.citySearch(destination);
		bookHotel.setCheckInDate();
		bookHotel.setCheckOutDate();
		bookHotel.setGuests("More options");
		bookHotel.addChildren("1");
		bookHotel.setChildsAge("11");
		bookHotel.search();
		bookHotel.selectDistrict("Lambeth");
		bookHotel.selectFirstHotelOnList();
		bookHotel.bookRoom();
		bookHotel.enterDetails("mr","Christopher","Clark","g.kanizaj.clark1234@gmail.com");
		bookHotel.confirmReservation("48 Lyle Street", "Melbourne", "3056", "0422448241");
		bookHotel.reserveBooking("Visa", "12345678", "01", "2017" );
	}

	public void startBrowser() {
		driver = new FirefoxDriver();
		driver.get("http://www.booking.com.au");
		driver.manage().window().maximize();
	}
	public void clearSearch() {
		searchField = driver.findElement(By.xpath("//*[@id='destination']"));
	}
	public void citySearch(String city){
		searchField.sendKeys(city);
		 WebElement suggestion = (new WebDriverWait(driver, 10))
	      		  .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='b2indexPage']/ul/li[1]/a")));
	        suggestion.click();
	}
	
	public void setCheckInDate() {
		// Select Calendar object
		WebElement checkInCalendar = (new WebDriverWait(driver, 10))
		 		  .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='first_calendar']")));
		checkInCalendar.click();
		WebElement nextMonth = (new WebDriverWait(driver, 10))
		 		  .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/div[1]/form/fieldset/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div[2]/div[2]/span")));
		// Navigate to December
		for (int i = 0;i < 4;i++){
			nextMonth.click();	
		}
		// Select 20th December
		 WebElement checkInDay = (new WebDriverWait(driver, 10))
	 		  .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frm']/fieldset/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div[2]/div[3]/div/div/div[5]/table/tbody/tr[4]/td[1]")));
		checkInDay.click();
	}
	public void setCheckOutDate() {
		// Select Calendar object
		
		WebElement checkOutCalendar = (new WebDriverWait(driver, 10))
	 		  .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frm']/fieldset/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[1]")));
		checkOutCalendar.click();
		
		WebElement nextMonth = (new WebDriverWait(driver, 10))
	 		  .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frm']/fieldset/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/span")));
		// Navigate to January
		nextMonth.click();	
		
		// Select 10th January
		WebElement checkOutDay = (new WebDriverWait(driver, 10))
			  .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frm']/fieldset/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div/div/div[6]/table/tbody/tr[3]/td[1]/span")));
		checkOutDay.click();
	}
	public void setGuests(String menuSelection) {
				
		// Select more Options
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@class='b-selectbox__element b-selectbox__groupselection']")));
		dropdown.selectByVisibleText(menuSelection);
		
	}
	public void addChildren(String numberOfChildren) {
		
		// Select Number of Children from dropdown
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@class='b-form-custom-group b-form-group b-form-group_subgroup']/div/div/div/div[3]/label/select")));
		dropdown.selectByValue(numberOfChildren);
		
	}
	public void setChildsAge(String age) {
		
		// Select Age of Child from dropdown
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@class='b-children-ages-configurator']/div/label/select")));
		dropdown.selectByValue(age);
		
	}
	public void search(){
		// Click Search button
		WebElement searchButton = (new WebDriverWait(driver, 10))
	     		  .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frm']/fieldset/div[5]/div/button/span")));
		searchButton.click();
	}
	public void selectDistrict(String district){
		// Click District to view available 
		WebElement districtsAvailable = (new WebDriverWait(driver, 10))
	     		  .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='filter_district']/div[1]/h3")));
		districtsAvailable.click();
		// Find the selected District
		WebElement selection = (new WebDriverWait(driver, 10))
	     		  .until(ExpectedConditions.elementToBeClickable(By.partialLinkText(district)));
		selection.click();
	}
	public void selectFirstHotelOnList() {
		// Store the current window handle
		winHandleBefore = driver.getWindowHandle();
		
		// Select the Hotel which is returned on the top of the list just to get this up and running
		WebElement headOfList = (new WebDriverWait(driver, 10))
	     		  .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='hotellist_inner']/div[1]/div[2]/div[1]/div[1]/h3/a")));
		headOfList.click();
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
				
		/*************************************************************
		// Perform the actions on new window
		// Close the new window, if that window no more required
		//	driver.close();
		// Switch back to original browser (first window)
		//	driver.switchTo().window(winHandleBefore);
		// Continue with original browser (first window)
		 ***************************************************************/
	}
	public void bookRoom() {
		//*[@id="b_tt_holder_6"]/button/ins
		//#b_tt_holder_5 > button > ins
	//	WebElement reserve = (new WebDriverWait(driver, 15))
	//    		  .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#b_tt_holder_5 > button > ins")));
	//	WebElement reserve = (new WebDriverWait(driver, 15))
	//			.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='recommendationHP']/div[2]/div/div[4]/a/span")));
		WebElement book = (new WebDriverWait(driver, 15))
							.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='hcta']")));
		book.click();
	}
	public void enterDetails(String title, String firstName, String lastName, String email){
		// Populate the details form with the required fields
		
		// Select Title
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@class='booker_title_select bp_input_select']")));
		dropdown.selectByValue(title);
		// Populate first Name
		WebElement firstNameField = driver.findElement(By.id("firstname"));
		firstNameField.sendKeys(firstName);
		// Populate last Name
		WebElement lastNameField = driver.findElement(By.id("lastname"));
		lastNameField.sendKeys(lastName);
		// Populate Email address
		WebElement emailAddressField = driver.findElement(By.id("email"));
		emailAddressField.sendKeys(email);
		// Populate confirm Email address
		WebElement confirmationEmailAddressField = driver.findElement(By.id("email_confirm"));
		confirmationEmailAddressField.sendKeys(email);
		
	// This Link works on the page it shows the Booking details popup
	//	WebElement bookingDetails = (new WebDriverWait(driver, 10))
	//		  	.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='bookconditions']")));
	//		bookingDetails.click();
	//WebElement proceed = (new WebDriverWait(driver, 10))
	 //	.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='b_tt_holder_6']/button")));
	// THIS FINALLY FINDS the Continue Button the xpath to the Button which can be seen above
	//	FAILS although this is what xpath Checker says it is !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	// continue to payment page
	WebElement proceed = (new WebDriverWait(driver, 10))
	 	.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Continue')]")));
	proceed.click();
	}
	public void confirmReservation(String address, String city, String postCode, String phoneNumber) {
		
		// Populate Address line
		WebElement addressField = driver.findElement(By.id("address1"));
		addressField.sendKeys("48 Lyle Street");
		// Populate City
		WebElement cityField = driver.findElement(By.id("city"));
		cityField.sendKeys("Melbourne");
		// Populate Postcode
		WebElement postCodeField = driver.findElement(By.id("zip"));
		postCodeField.sendKeys("3056");
		// Populate Phone number
		WebElement phoneNumberField = driver.findElement(By.id("phone"));
		phoneNumberField.sendKeys("0422448123");
	}
	public void reserveBooking(String cardType, String cardNumber, String expiryMonth, String expiryYear) {
		
		// Select Card Type
		Select card = new Select(driver.findElement(By.xpath("//*[@id='cc_type']")));
		card.selectByValue("Visa");
		// Populate card number
		WebElement cardNum = driver.findElement(By.id("cc_number"));
		cardNum.sendKeys("12345678");
	
		//Set Expiry Month
		Select expMonth = new Select(driver.findElement(By.xpath("//*[@id='cc_month']")));
		expMonth.selectByValue("03");
		//Set Expiry Year
		Select expYear = new Select(driver.findElement(By.xpath("//*[@id='ccYear']")));
		expYear.selectByValue("2017");
		
		try {
			Thread.sleep(10000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		driver.quit();
	}
}