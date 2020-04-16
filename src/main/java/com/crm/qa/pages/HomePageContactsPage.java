package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.basepractice.TestBasePractice;

public class HomePageContactsPage extends TestBasePractice {
	
	//page objects - OR
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(name="title")
	WebElement dropdown;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	//Initializing page objects
	public HomePageContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean verifyHomePageContactsPageLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name){
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void newContact(String title, String ftName, String ltName, String com){
		Select select = new Select(dropdown);
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(com);
		saveBtn.click();	
		
	}

}
