package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[contains(text(),'Input Forms')]//b")
	WebElement inputForm;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle'][contains(text(),'Date pickers')]")
	WebElement datepickers;
	
	@FindBy(linkText = "Table")
	WebElement table;
	
	
	public void clickInputForm() {
		inputForm.click();
	}
	
	public void clickDatePicker() {
		datepickers.click();
	}
	
	public void clickTable() {
		table.click();
	}
	
	
}
