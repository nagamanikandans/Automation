package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.MyAddressPage;
import com.mystore.qa.pages.SignInPage;


public class SignInPageTest extends TestBase {

	SignInPage SignInPage;
	LoginPage LoginPage;
	
	public SignInPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		SignInPage = new SignInPage();
		}
	
	@Test(priority=1)
	public void SignInPageTitleTest() {
		String Title = SignInPage.validateLoginPageTitle();
		Assert.assertEquals(Title, "My Store");
	}
	
	@Test(priority=2)
	public void SignInPageLogoTest() {
		boolean logo = SignInPage.validateLogoImage();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void SignInTest() {
		LoginPage = SignInPage.SignIn();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
