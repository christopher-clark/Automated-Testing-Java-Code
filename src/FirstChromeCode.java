import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;




public class FirstChromeCode {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/\\Program Files/\\Google/\\Chrome/\\Application/\\chromedriver.exe");
		//Set the location of chrome.exe in case Chrome browser installed on custom location
		System.out.println("Set Property");
		ChromeOptions options = new ChromeOptions();
		System.out.println("Set Options");
		options.setBinary("C:/\\Program Files/\\Google/\\Chrome/\\Application/\\chrome.exe");
		System.out.println("Set Binary");
		WebDriver driver = new ChromeDriver(options);
		System.out.println("Created Driver");
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		System.out.println("After the Get www.google.com command");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese");
		element.submit();
		System.out.println("Page title is " + driver.getTitle());
	/*	try {
			Thread.sleep(5000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	*/	(new WebDriverWait(driver, 10)).until(
				new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						System.out.println("JavaScript Driver d title is: " + d.getTitle().toLowerCase());
						return d.getTitle().toLowerCase().startsWith("cheese");}
				});
		if(driver.getTitle().toLowerCase().startsWith("cheese")) {
		System.out.println("Page title is: " + driver.getTitle().toLowerCase());
		}
		driver.quit();
	}
}
					