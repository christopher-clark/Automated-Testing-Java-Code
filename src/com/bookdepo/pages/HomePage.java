package com.bookdepo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	/*
	 *  Sidebar Elements
	 */
	
	@FindBy(linkText="Art & Photography")
	WebElement art_and_photography_link;
	
	@FindBy(linkText="Audio Books")
	WebElement audio_books_link;
	
	@FindBy(linkText="Biography")
	WebElement biography_link;
	
	@FindBy(linkText="Business, Finance & Law")
	WebElement business_finance_and_law_link;
	
	@FindBy(linkText="Childrens's")
	WebElement childrens_books_link;
	
	@FindBy(linkText="Computing")
	WebElement computing_link;
	
	@FindBy(linkText="Crafts & Hobbies")
	WebElement craft_and_hobbies_link;
	
	@FindBy(linkText="Crime & Thriller")
	WebElement crime_and_thriller_link;
	
	@FindBy(linkText="Dictionaries & Languages")
	WebElement dictionaries_and_languages_link;

	@FindBy(linkText="Entertainment")
	WebElement entertainment_link;
	
	@FindBy(linkText="Art ")
	WebElement fiction_link;
	
	@FindBy(linkText="Food & Drink")
	WebElement food_and_drink_link;
	
	@FindBy(linkText="Graphic Novels, Anime & Manga")
	WebElement graphic_novels_anime_and_manga_link;
	
	@FindBy(linkText="Health")
	WebElement health_link;
	
	@FindBy(linkText="History & Archaeology")
	WebElement history_and_archaeology_link;
	
	@FindBy(linkText="Home & Garden")
	WebElement home_and_garden_link;
	
	@FindBy(linkText="Humour")
	WebElement humour_link;
	
	@FindBy(linkText="Medical")
	WebElement medical_link;
	
	@FindBy(linkText="Mind, Body & Spirit")
	WebElement mind_body_and_spirit_link;
	
	@FindBy(linkText="Natural History")
	WebElement natural_history_link;
	
	@FindBy(linkText="Personal Development")
	WebElement personal_development_link;
	
	@FindBy(linkText="Poetry & Drama")
	WebElement poetry_and_drama_link;
	
	@FindBy(linkText="Reference")
	WebElement reference_link;
	
	@FindBy(linkText="Religion")
	WebElement religion_link;
	
	@FindBy(linkText="Romance")
	WebElement romance_link;
	
	@FindBy(linkText="Science & Geography")
	WebElement science_and_geography_link;
	
	@FindBy(linkText="Science Fiction, Fantasy & Horror")
	WebElement science_fiction_fantasy_and_horror_link;
	
	@FindBy(linkText="Society & Social Sciences")
	WebElement society_and_social_sciences_link;
	
	@FindBy(linkText="Sport")
	WebElement sport_link;
	
	@FindBy(linkText="Stationery")
	WebElement stationery_link;
	
	@FindBy(linkText="Teaching Resources & Education")
	WebElement teaching_resources_and_education_link;
	
	@FindBy(linkText="Technology & Engineering")
	WebElement technology_and_engineering_link;
	
	@FindBy(linkText="Transport")
	WebElement transport_link;
	
	@FindBy(linkText="Travel & Holiday Guides")
	WebElement travel_and_holiday_guides_link;
	
	public void viewSitemap(){
		sitemap_link.click();
	}
}
