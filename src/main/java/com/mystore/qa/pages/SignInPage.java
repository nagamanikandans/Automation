package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class SignInPage extends TestBase {
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement signin;
	
	@FindBy(xpath="//*[@id=\"header_logo\"]/a/img")
	WebElement yourLogo;
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateLogoImage(){
		return yourLogo.isDisplayed();
	}
	
	public LoginPage SignIn() {
		signin.click();		
		return new LoginPage();
	}
}
