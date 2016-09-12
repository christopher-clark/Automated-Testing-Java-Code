package com.bookdepo.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.bookdepo.pages.HomePage;
import com.bookdepo.pages.LoginPage;
import com.bookdepo.utils.BrowserFactory;

public class HomepageTest {

	@Test
	public void viewSitemap(){
		// This will launch Browser
		WebDriver driver = BrowserFactory.startBrowser("chrome", "https://www.bookdepository.com/");
		// Create PageObject & call method
		HomePage home_page = PageFactory.initElements(driver,HomePage.class);
		home_page.viewSitemap();
		WebElement header2 = driver.findElement(By.xpath("//h2"));
		String str = header2.getText();
		System.out.println(str);
		Assert.assertEquals(str, "Main site links");
	//	driver.close();
		
	}
}
