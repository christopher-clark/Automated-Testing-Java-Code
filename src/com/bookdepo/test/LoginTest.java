package com.bookdepo.test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bookdepo.pages.LoginPage;
import com.bookdepo.utils.BrowserFactory;

public class LoginTest {

	@Test
	public void validLogin(){
		// This will launch Browser
		WebDriver driver = BrowserFactory.startBrowser("firefox", "https://www.bookdepository.com/account/login/to/account");
		// Create PageObject & call method
		LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
		login_page.signIn("g,.kanizaj.clark@gmail.com","1Ev0st0r!");
		assert(driver.getPageSource().contains("Hello Christopher Clark"));
		driver.close();
		
	}
	
	@Test
	public void invalidLogin(){
		// This will launch Browser
		WebDriver driver = BrowserFactory.startBrowser("chrome", "https://www.bookdepository.com/account/login/to/account");
		// Create PageObject & call method
		LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
		login_page.signIn("g.kanizaj.clark@gmail.com","Ev0st0r!");
		assert(driver.getPageSource().contains("Sorry, the email address and/or password were incorrect. Please try again."));
		driver.close();
	}
}
