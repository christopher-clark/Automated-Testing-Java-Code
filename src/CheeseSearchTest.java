import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheeseSearchTest {

	static private WebDriver driver;
	private WebElement element;
	
	@BeforeClass
    public static void startBrowser() {
		driver = new FirefoxDriver();
    }

		
	@After
	public void closeWindow() {
		driver.close();
	}
	public void helloeWorld() {
		System.out.println("Hello World");
	}
	
	@AfterClass
    public static void closeBrowser() {
		driver.quit();
    }
	@Test
	public void testTitleTrue() {
		driver.get("http://www.google.com");
		element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese");
		element.submit();
		assertEquals(driver.getTitle(),"Google");
		// Added a comment
		
		// Wait for either 10 seconds or Page has loaded
		(new WebDriverWait(driver, 10)).until(
				new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						return d.getTitle().toLowerCase().startsWith("cheese");
						}
				}
		);
		assertTrue(driver.getTitle().toLowerCase().startsWith("cheese"));
	}
	@Test
	public void testTitleFalse() {
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese");
		element.submit();
		assertEquals(driver.getTitle(),"Google");
		
		// Wait for either 10 seconds or Page has loaded
		(new WebDriverWait(driver, 10)).until(
				new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						return d.getTitle().toLowerCase().startsWith("cheese");
						}
				}
		);
		assertFalse(driver.getTitle().toLowerCase().startsWith("1cheese"));
	}
	@Test
	public void thirdLinkTest(){
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
        
        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese");
        query.submit();
        
     // Wait for either 10 seconds or Link is Clickable
        WebElement brunyIslandLink = (new WebDriverWait(driver, 10))
      		  .until(ExpectedConditions.elementToBeClickable(By.partialLinkText("- Ashgrove Cheese")));
        brunyIslandLink.click();
        
        // 5 Second Sleep
        try {
			Thread.sleep(5000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        assertEquals(driver.getTitle(),"For Cheese, Milk, Butter, Cream - Ashgrove Cheese, Tasmania, Australia");
 	}
	@Test
	public void findLinkByXpath(){
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
        
        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese");
        query.submit();
        
     // Wait for either 10 seconds or Link is Clickable
     // 2nd Link "Cheese.com - Worlds's Greatest cheese Resource Webpage
       WebElement xPathLink = (new WebDriverWait(driver, 10))
      		  .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='rso']/div[2]/li[2]/div/h3/a")));
        xPathLink.click();
                
        try {
			Thread.sleep(15000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
     }
	@Test
	public void findLinkByCssSelector(){
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
        
        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese");
        query.submit();
        
     // Wait for either 10 seconds or Link is Clickable
     // 1st Link "Cheese-Wikipedia Webpage
        WebElement CSSPathLink = (new WebDriverWait(driver, 10))
      		  .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#rso > div:nth-child(2) > li:nth-child(1) > div > h3 > a")));
        CSSPathLink.click();
                
        try {
			Thread.sleep(15000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
     }
}
