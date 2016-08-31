package com.exercises.selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

public class FirefoxDriverTest {
	
	@Test
	public void testGoogleSearch() throws InterruptedException {
	 
	  WebDriver driver = new FirefoxDriver();
	  driver.get("http://www.google.com/xhtml");
	  Thread.sleep(5000);  // Let the user actually see something!
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("FirefoxDriver");
	  searchBox.submit();
	  Thread.sleep(5000);  // Let the user actually see something!
	  driver.quit();
	}
}
