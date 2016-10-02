import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class XPathTest {
	
	String[] currencies = {"AUD","EUR","GBP","NZD","SGD","HKD","CAD","CZK","ILS","JPY","NOK","PLN","SEK","CHF",
			"THB","DKK","HUF","TWD","ZAR","MXN","ARS","CLP","MYR","KRW","IDR"};
	
	
	@Test
	public void currencyTest(){

	// This will launch Browser
	WebDriver driver = BrowserFactory.startBrowser("chrome", "https://www.bookdepository.com");
	// Create PageObject & call method
	XPathPage xpath_page = PageFactory.initElements(driver, XPathPage.class);
	
	
	xpath_page.viewCurrencies();
	
	WebElement dictionaries = driver.findElement(By.linkText("Food & Drink"));
	dictionaries.click();
		for(String cur : currencies){
			xpath_page.selectCurrency(cur);
			rest();
		}
	}
	
	public void rest(){
		try{
			Thread.sleep(100);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
}
