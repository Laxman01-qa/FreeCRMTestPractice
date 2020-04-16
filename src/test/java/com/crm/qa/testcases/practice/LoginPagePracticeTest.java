package com.crm.qa.testcases.practice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.basepractice.TestBasePractice;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.CustomersPage;
import com.crm.qa.pages.FeaturesPage;
import com.crm.qa.pages.HomePagePractice;
import com.crm.qa.pages.LoginPagePractice;
import com.crm.qa.pages.PricingPage;
import com.crm.qa.pages.SignUpPage;

public class LoginPagePracticeTest extends TestBasePractice {
	
	LoginPagePractice loginPagePractice;
	HomePagePractice homePagePractice;
	SignUpPage signUpPage;
	PricingPage pricingPage;
	FeaturesPage featuresPage;
	CustomersPage customersPage;
	ContactPage contactPage;
	
	public LoginPagePracticeTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
	    loginPagePractice = new LoginPagePractice();
	    signUpPage = new SignUpPage();
	    homePagePractice = new HomePagePractice();
	    pricingPage = new PricingPage();
	    featuresPage = new FeaturesPage();
	    customersPage = new CustomersPage();
	    contactPage = new ContactPage();
	}
   
	@Test
	public void validateLoginPageTitleTest(){
	String title = loginPagePractice.validateLoginPageTitle();
	Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test
	public void validateLoginPageCRMImageTest(){
	Assert.assertTrue(loginPagePractice.validateLoginPageCRMImage());
	}
	
	@Test
	public void verifySignUpLnkTest(){
	signUpPage = loginPagePractice.verifySignUpLnk();
	}
	
	@Test
	public void verifyPricingLnkTest(){
	pricingPage = loginPagePractice.verifyPricingLnk();	
	}
	
	@Test
	public void verifyFeaturesLnkTest(){
	featuresPage = loginPagePractice.verifyFeaturesLnk();	
	}
	
	@Test
	public void verifyCustomersLnkTest(){
	customersPage = loginPagePractice.verifyCustomersLnk();	
	}
	
	@Test
	public void verifyContactLnkTest(){
	contactPage = loginPagePractice.verifyContactLnk();
	}
	
	@Test
	public void loginPracticeTest(){
    homePagePractice = loginPagePractice.LoginPractice(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
}	
