package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.basepractice.TestBasePractice;

public class HomePagePractice extends TestBasePractice{
	
	//Page object - OR
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement userLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Calendar')]")
	WebElement calendarLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	//initialize page objects
	public HomePagePractice(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyHomePageUserLabel(){
		return userLabel.isDisplayed();
	}
	
	public HomePageContactsPage verifyHomePageContactsPageLink(){
		contactsLink.click();
		return new HomePageContactsPage();
	}
	
	public HomePageDealsPage verifyHomePageDealsPageLink(){
		dealsLink.click();
		return new HomePageDealsPage();
	}
	
	public HomePageCalendarPage verifyHomePageCalendarPageLink(){
		calendarLink.click();
		return new HomePageCalendarPage();
	}
	
	public void clickOnNewContactLink(){
		//create Actions builder instance by passing weddriver instance
		Actions builder = new Actions(driver);
		builder.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}

}
