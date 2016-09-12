package com.bookdepo.pages;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	@FindBy(id="username")
	WebElement emailAddress;
	
	@FindBy(id="password")
	WebElement passwd;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement loginButton;
	
	@FindBy(linkText="Forgotten password?")
	WebElement forgotten_password_link;
	
	
	public void signIn(String username, String password){
		emailAddress.sendKeys(username);
		passwd.sendKeys(password);
		loginButton.click();
	}
	
	

}
