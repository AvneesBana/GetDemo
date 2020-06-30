package com.qa.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.util.TestUtil;

public class HomeTest extends TestBase{
    public HomePage homePage;
    public WebDriver driver;
	
	public HomeTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		homePage=new HomePage();
	}
	
	@Test
	public void execution() throws InterruptedException {
		homePage.clickInputForm();
		TestUtil.captureScreenShot(driver, "ClickontheInputForm");
		Thread.sleep(3000);
		homePage.clickDatePicker();
		homePage.clickTable();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	

}
