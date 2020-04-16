package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.basepractice.TestBasePractice;

public class LoginPagePractice extends TestBasePractice {
	
	//Page Object - OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpLink;
	
	@FindBy(xpath="//a[contains(text(),'Pricing')]")
	WebElement pricingLink;
	
	@FindBy(xpath="//a[contains(text(),'Features')]")
	WebElement featuresLink;
	
	@FindBy(xpath="//a[conatins(text(),'Customers']")
	WebElement customersLink;
	
	@FindBy(xpath="//a[conatins(text(),'Contact']")
	WebElement contactLink;
	
	//Initialization using page object
	public LoginPagePractice(){
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
		
	}
	
	public boolean validateLoginPageCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public SignUpPage verifySignUpLnk(){
		signUpLink.click();
		
		return new SignUpPage();
	}
	
	public PricingPage verifyPricingLnk(){
		pricingLink.click();
		
		return new PricingPage();
	}
	
	public FeaturesPage verifyFeaturesLnk(){
		featuresLink.click();
		
		return new FeaturesPage();
	}
	
	public CustomersPage verifyCustomersLnk(){
		customersLink.click();
		
		return new CustomersPage();
	}
	
	public ContactPage verifyContactLnk(){
		contactLink.click();
		
		return new ContactPage();
	}
	
	public HomePagePractice LoginPractice(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePagePractice();
		
	}
	
}
