package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.SignInPage;

public class LoginPageTest extends TestBase{

	SignInPage SignInPage;
	LoginPage LoginPage;

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		SignInPage = new SignInPage();
		SignInPage.SignIn();
		LoginPage = new LoginPage();
		}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String LoginPageTitle = LoginPage.LoginInPageTitle();
		Assert.assertEquals(LoginPageTitle, "Login - My Store");
	}

	@Test(priority=2)
	public void LogInTest() {
		LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
