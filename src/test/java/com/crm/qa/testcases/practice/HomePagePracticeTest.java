package com.crm.qa.testcases.practice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.basepractice.TestBasePractice;
import com.crm.qa.pages.HomePageCalendarPage;
import com.crm.qa.pages.HomePageContactsPage;
import com.crm.qa.pages.HomePageDealsPage;
import com.crm.qa.pages.HomePagePractice;
import com.crm.qa.pages.LoginPagePractice;
import com.crm.qa.utilpractice.TestUtilPractice;

public class HomePagePracticeTest extends TestBasePractice{
	
	LoginPagePractice loginPagePractice;
	TestUtilPractice testUtilPractice;
	HomePagePractice homePagePractice;
	HomePageContactsPage homePageContactsPage;
	HomePageDealsPage homePageDealsPage;
	HomePageCalendarPage homePageCalendarPage;
	
	public HomePagePracticeTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPagePractice = new LoginPagePractice();
		testUtilPractice = new TestUtilPractice();
		homePagePractice = loginPagePractice.LoginPractice(prop.getProperty("username"),prop.getProperty("password")); 
		homePagePractice = new HomePagePractice();
		homePageContactsPage = new HomePageContactsPage();
		homePageDealsPage = new HomePageDealsPage();
		homePageCalendarPage = new HomePageCalendarPage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyHomePageUserLabelTest(){
		testUtilPractice.switchToFrame();
		boolean flag = homePagePractice.verifyHomePageUserLabel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyHomePageContactsPageLinkTest(){
		testUtilPractice.switchToFrame();
		homePageContactsPage = homePagePractice.verifyHomePageContactsPageLink();
	}
	
	@Test(priority=4)
	public void verifyHomePageDealsPageLinkTest(){
		testUtilPractice.switchToFrame();
		homePageDealsPage = homePagePractice.verifyHomePageDealsPageLink();
	}
	
	@Test(priority=5)
	public void verifyHomePageCalendarPageLinkTest(){
		testUtilPractice.switchToFrame();
		homePageCalendarPage = homePagePractice.verifyHomePageCalendarPageLink();
	}

}
