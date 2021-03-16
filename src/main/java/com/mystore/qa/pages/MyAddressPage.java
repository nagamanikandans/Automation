package com.mystore.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class MyAddressPage extends TestBase {


	@FindBy(xpath="//*[@id=\"center_column\"]/div/a/span")
	WebElement addNewAddress;
	
	public MyAddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateAddressPageTitle(){
		return driver.getTitle();
	}
	
	public AddNewAddress addNewAdd() {
		addNewAddress.click();
		return new AddNewAddress();
	}
}
