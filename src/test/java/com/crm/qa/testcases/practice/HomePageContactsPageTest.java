package com.crm.qa.testcases.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.basepractice.TestBasePractice;
import com.crm.qa.pages.HomePageContactsPage;
import com.crm.qa.pages.HomePagePractice;
import com.crm.qa.pages.LoginPagePractice;
import com.crm.qa.utilpractice.TestUtilPractice;

public class HomePageContactsPageTest extends TestBasePractice {
	
	LoginPagePractice loginPagePractice;
	TestUtilPractice testUtilPractice;
	HomePagePractice homePagePractice;
	HomePageContactsPage homePageContactsPage;
	
	String sheetName ="Contacts";
	
	public HomePageContactsPageTest(){
		super();
	}
    
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPagePractice = new LoginPagePractice();
		testUtilPractice = new TestUtilPractice();
		homePagePractice = loginPagePractice.LoginPractice(prop.getProperty("username"), prop.getProperty("password"));
		homePagePractice = new HomePagePractice();
		testUtilPractice.switchToFrame();
		homePageContactsPage = homePagePractice.verifyHomePageContactsPageLink();
		homePageContactsPage = new HomePageContactsPage();
	}
	
	@Test(priority=1)
	public void verifyHomePageContactsPageLabelTest(){
		Boolean flag = homePageContactsPage.verifyHomePageContactsPageLabel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=1)
	public void selectContactsTest(){
		homePageContactsPage.selectContactsByName("Aakash Patel");
		homePageContactsPage.selectContactsByName("Aakash Shah");
		
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		Object inputData[][] = testUtilPractice.getTestData(sheetName);
		return inputData;	
	}
	
	@Test(priority=3, dataProvider="getData")
	public void newContactTest(String title, String ftName, String ltName, String com){
		homePagePractice.clickOnNewContactLink();
		homePageContactsPage.newContact(title, ftName, ltName, com);
	}
}
