package com.bookdepo.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url){
		
		switch(browserName){
		
		case "firefox" :
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		case "chrome" :
			System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		default :
			System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		}
	}
}
