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

public class MyAddressPageTest extends TestBase {

	SignInPage SignInPage;
	LoginPage LoginPage;
	MyAccountPage MyAccountPage;
	MyAddressPage MyAddressPage;
	
	public MyAddressPageTest() {
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
		MyAccountPage.navigateMyAddress();	
		MyAddressPage = new MyAddressPage();
	}
	
	@Test(priority=1)
	public void myAddressPageTitleTest() {
		String AddressPageTitle = MyAddressPage.validateAddressPageTitle();
		Assert.assertEquals(AddressPageTitle, "Addresses - My Store");
	}
	
	@Test(priority=2)
	public void AddnewAddress() {
		MyAddressPage.addNewAdd();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
