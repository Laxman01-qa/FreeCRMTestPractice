package com.crm.qa.testcases.practice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.basepractice.TestBasePractice;
import com.crm.qa.pages.LoginPagePractice;
import com.crm.qa.pages.SignUpPage;

public class SignUpPageTest extends TestBasePractice {
		
		LoginPagePractice loginPagePractice;
		SignUpPage signUpPage;
		
		
		public SignUpPageTest(){
			super();
		}
		
		@BeforeMethod
		public void setUp(){
			initialization();
			loginPagePractice = new LoginPagePractice();
			signUpPage = loginPagePractice.verifySignUpLnk();
			signUpPage = new SignUpPage();
		}
		
		@Test(priority=1)
		public void verifySignUpPageTitleTest(){
		String signUpTitle = signUpPage.verifySignUpPageTitle();
		Assert.assertEquals(signUpTitle, "Cogmento CRM");
		}
		
		@Test(priority=2)
		public void verifySignUpPgaeLabelTest(){
		Boolean flag = signUpPage.verifySignUpPgaeLabel();
		Assert.assertTrue(flag);	
		}
	}

