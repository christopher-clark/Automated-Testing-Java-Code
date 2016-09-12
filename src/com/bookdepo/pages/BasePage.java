package com.bookdepo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	/*
	 *  Header Elements
	 */

	@FindBy(className="icon-home")
	WebElement home;
	
	@FindBy(linkText="Contact Us")
	WebElement contact_us_link;
	
	@FindBy(linkText="Help")
	WebElement help_link;
	
	@FindBy(linkText="Order Status")
	WebElement order_status_link;
	
	@FindBy(linkText="Wishlist")
	WebElement wishlist_link;
	
	@FindBy(linkText="Sign in/Join")
	WebElement sign_in_join_link;
	
	/*
	 * Primary Wrapper
	 */
	
	@FindBy(name="brand-link")
	WebElement brandLink;
	
	@FindBy(name="header-search-btn")
	WebElement searchButton;
	
	@FindBy(id="book-search")
	WebElement searchText;
	
	/*
	 * Secondary Header
	 */
	
	@FindBy(linkText="Bestsellers")
	WebElement bestsellers_link;
	
	@FindBy(linkText="Coming Soon")
	WebElement coming_soon_link;
	
	@FindBy(linkText="Highlights")
	WebElement highlights_link;
	
	@FindBy(linkText="Bargain Shop")
	WebElement bargain_shop_link;
	
	@FindBy(id="selectCurrency")
	Select currencySelector;
	
	/*
	 * Footer Elements
	 */
	
	@FindBy(linkText="About us")
	WebElement about_us_link;
	
	@FindBy(linkText="Sitemap")
	WebElement sitemap_link;
	
	@FindBy(linkText="Bookmarks")
	WebElement bookmarks_link;
	
	@FindBy(linkText="Where's my stuff?")
	WebElement wheres_my_stuff_link;
	
	@FindBy(linkText="Where do you deliver?")
	WebElement where_do_you_deliver_link;
	
	@FindBy(linkText="Affiliates")
	WebElement affiliates_link;
	
	@FindBy(linkText="Jobs")
	WebElement jobs_link;
	
	@FindBy(linkText="Cookies")
	WebElement cookies_link;
	
	@FindBy(linkText="Privacy Policy")
	WebElement privacy_policy_link;
	
	@FindBy(linkText="Terms & Conditions")
	WebElement terms_and_conditions_link;
	
	@FindBy(linkText="Secure Shopping")
	WebElement secure_shopping_link;
	
	@FindBy(linkText="Accessibility")
	WebElement accessibility_link;
	
}
