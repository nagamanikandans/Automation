package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.MyAccountPage;
import com.mystore.qa.pages.MyAddressPage;
import com.mystore.qa.pages.SignInPage;

public class MyAccountPageTest extends TestBase {

	SignInPage SignInPage;
	LoginPage LoginPage;
	MyAccountPage MyAccountPage;
	
	public MyAccountPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		SignInPage = new SignInPage();
		SignInPage.SignIn();
		LoginPage = new LoginPage();
		LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		MyAccountPage = new MyAccountPage();
		}
	
	@Test(priority=1)
	public void myAccountPageTitleTest() {
		String AccountPageTitle = MyAccountPage.validateMyAccountTitle();
		Assert.assertEquals(AccountPageTitle, "My account - My Store");
	}
	
	@Test(priority=2)
	public void NavigateMyAddressPage() {
		MyAccountPage.navigateMyAddress();		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
