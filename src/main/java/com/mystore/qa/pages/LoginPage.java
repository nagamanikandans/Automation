package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(id="SubmitLogin")
	WebElement signInButton;
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="passwd")
	WebElement password;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String LoginInPageTitle() {
		return driver.getTitle();
	}
	public boolean ValidateSignInButton() {
		return signInButton.isDisplayed();
	}
	public MyAccountPage login(String usrname, String pwd) {
		username.sendKeys(usrname);
		password.sendKeys(pwd);
		signInButton.click();
		return new MyAccountPage();
	}
}
