package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.basepractice.TestBasePractice;

public class SignUpPage extends TestBasePractice {
		
		//Page Object - OR
		@FindBy(xpath="//h2[contains(text(),'Register')]")
		WebElement signUpLabel;
		
		//Initialize page objects
		public SignUpPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public String verifySignUpPageTitle(){
			return driver.getTitle();
		}
		
		public boolean verifySignUpPgaeLabel(){
			return signUpLabel.isDisplayed();
		}	
		
	}

