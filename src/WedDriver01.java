/*
 * Copyright JK Vine
 * 
 * Training material - Selenium Test Automation
 * 
 * Lesson  1: Driving Chrome in Java - get the supplied code working
 *  The code did not have any:
 *   - imports
 *   - link to the driver executable
 *   - 
 *   
 * Challenge: Clicking the 3rd Link on the page.
 *  Two Solutions:
 *   a. 3rd link including the ads
 *    //*li[3]/div/h3/a
 *   b. 3rd link excluding the ads 
 *    //*[@class='g'][3]/div/h3/a  
 *   
 *   Synchronising is required to make this work.
 *    Two sync methods:
 *     a. Sleep for a time
 *     b. WebDriverWait
 * 
 * Lesson 2: Driving a web site
 * 
 */

import java.io.IOException;

import org.openqa.selenium.By; //*
import org.openqa.selenium.WebDriver;//*
import org.openqa.selenium.WebElement;//*
import org.openqa.selenium.chrome.ChromeDriver;//*
import org.openqa.selenium.support.ui.ExpectedCondition;//*
import org.openqa.selenium.support.ui.ExpectedConditions;//*
import org.openqa.selenium.support.ui.WebDriverWait;//*

import com.google.gson.Gson;


@SuppressWarnings("unused")
public class WedDriver01 {
	
	public static void main(String [] args)
	{
		// added to execute the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		
		//original code
		WebDriver driver = new ChromeDriver(); 
		driver.get("http://www.google.com"); 
		WebElement element = driver.findElement(By.name("q"));
		 //added to satisfy the type required
		CharSequence value = "Cheese!";
		element.sendKeys(value); 		
		element.submit(); 
		
		System.out.println("Page title is: " + driver.getTitle()); 
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>()
		{ 
			public Boolean apply(WebDriver d)
			{
				return d.getTitle().toLowerCase().startsWith("cheese!");
			} 
		});
		
		System.out.println("Page title is: " + driver.getTitle()); 
		
		//NEW: Sync to wait for the element
		element = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='g'][3]/div/h3/a")));
		
		final String s = element.getText();
		element.click();

		// NEW used the links real text to identify when we are on the page
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>()
		{ 
			public Boolean apply(WebDriver d)
			{
				return d.getTitle().toLowerCase().equals(s.toLowerCase());
			} 
		});

		System.out.println("Page title is: " + driver.getTitle()); 
		
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //original
		driver.quit();
	}

}


