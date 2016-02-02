import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstFirefoxCode {
	
	private WebDriver driver;
	
	public static void main(String[] args) {
		FirstFirefoxCode firstFirefoxCode = new FirstFirefoxCode();
	//	firstFirefoxCode.cheeseSearch();
	//	firstFirefoxCode.clashSearch();
	//	firstFirefoxCode.thirdCheeseLink();
	//	firstFirefoxCode.searchLinkList();
		firstFirefoxCode.findLinkByXpath();
	}
	public void cheeseSearch() {
		
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		// Adding a Comment on 2/2/2016
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese");
		element.submit();
		System.out.println("Page title is " + driver.getTitle());
	
		// Wait for either 10 seconds or Page has loaded
		(new WebDriverWait(driver, 10)).until(
				new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						return d.getTitle().toLowerCase().startsWith("cheese");
					}
				}
		);
		
		if(driver.getTitle().toLowerCase().startsWith("cheese")) {
		System.out.println("Page title is: " + driver.getTitle().toLowerCase());
		}
		else {
			System.out.println("Page title does not start with cheese");
		}
		driver.close();
		driver.quit();
		System.out.println("Second Commit");
	}
	public void thirdCheeseLink(){
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
        
        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese");
        query.submit();
        
     // Wait for either 10 seconds or Link is Clickable
        WebElement brunyIslandLink = (new WebDriverWait(driver, 10))
      		  .until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Bruny Island Cheese")));
        brunyIslandLink.click();
                
        try {
			Thread.sleep(5000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        driver.close();
        driver.quit();
	}
	public void clashSearch() {
		
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
        
        // Enter the query string "The Clash"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("The Clash");
        query.submit();
        
        try {
			Thread.sleep(5000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        
        // Wait for either 10 seconds or Link is Clickable
        WebElement wikipediaLink = (new WebDriverWait(driver, 10))
        		  .until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Wikipedia")));
        wikipediaLink.click();
               
        try {
			Thread.sleep(5000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        driver.close();
        driver.quit();
	}
	public void searchLinkList() {
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
        
        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese");
        query.submit();
        
     // Wait for either 10 seconds or Page has loaded
     	(new WebDriverWait(driver, 10)).until(
     		new ExpectedCondition<Boolean>() {
     			public Boolean apply(WebDriver d) {
     				return d.getTitle().toLowerCase().startsWith("cheese");
     			}
     		}
     	);
       	// Read all of the links returned into a List Collection
    
     	//*[@id="rso"]/div[2]/li[1]/div/h3/a
     	//*[@id="rso"]/div[2]/li[2]/div/h3/a
     	//*[@id="rso"]/div[2]/li[3]/div/h3/a
     
    List<WebElement> links = driver.findElements(By.xpath("//*[@class='g']/div/h3/a"));
     	System.out.println("Number of elements: " + links.size());
     	   	for(WebElement listElement : links){
     	   		System.out.println("Element Names are  = " + listElement.getText());
        	}
        driver.close();
        driver.quit();
	}
	public void findLinkByXpath(){
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
        
        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese");
        query.submit();
        
     // Wait for either 10 seconds or Link is Clickable
            
        // Finds [Xth] link(s) /div/h3/a element - ie the Clickable Link via "ires" Id
       // WebElement xPathLink = (new WebDriverWait(driver, 10))
        //		  .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ires']/ol/div/li[3]/div/h3/a")));
       // Finds first element via ires
        //   WebElement xPathLink = (new WebDriverWait(driver, 10))
      //		  .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ires']/ol/div/li/div/h3/a")));
       // link(s) /div/h3/a element - ie the Clickable Link [@class='g'] ( This ignores Adverts & News
      //  WebElement foundById = (new WebDriverWait(driver, 10))
      //  		  .until(ExpectedConditions.elementToBeClickable(By.id("//*[@id='rso']/div[2]/li[1]/div/h3/a")));
      //  foundById.click();
        
        
        WebElement xPathLink = (new WebDriverWait(driver, 10))
              		  .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='g'][2]/div/h3/a")));
        xPathLink.click();
                
        try {
			Thread.sleep(15000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        driver.close();
        driver.quit();
	}
}


