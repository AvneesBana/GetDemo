package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class FormPage extends TestBase{

	public FormPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(name="email")
	WebElement emailAddress;
	
	@FindBy(name="phone")
	WebElement phoneNumber;
	
	@FindBy(name="address")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="zip")
	WebElement zip;
	
	@FindBy(name="website")
	WebElement website;
	
	@FindBy(name="comment")
	WebElement comment;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement clickSend;
	
	
	public String getTitleFormPage() {
		return driver.getTitle();
	}

	
	public void fillData(String fn,String ln,String email, String phone, String add, String cit, String zi, String web, String com ) {
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		emailAddress.sendKeys(email);
		phoneNumber.sendKeys(phone);
		address.sendKeys(add);
		city.sendKeys(cit);
		zip.sendKeys(zi);
		website.sendKeys(web);
		comment.sendKeys(com);
	}
	
	public void clickSend() {
		clickSend.click();
	}
	
	
	
	
}
