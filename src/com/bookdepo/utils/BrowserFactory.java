package com.bookdepo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url){
		
		switch(browserName){
			case "firefox" :
				System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\Geckodriver.exe");
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
			case "IE" :
				System.setProperty("webdriver.ie.driver", "C:\\IEDriver\\IEDriverServer.exe");
				WebDriver driverIE=new InternetExplorerDriver();
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
