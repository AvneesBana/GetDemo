package com.qa.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FormPage;
import com.qa.util.TestUtil;

public class FormTest extends TestBase{

	public FormPage formPage;
	
	
	
	public FormTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		formPage=new FormPage();
	}
	
	
	@Test(dataProvider = "getDataFromExcel")
	public void fillDataExecution(String firstName, String lastName, String email, String phoneNumber, String address, String city, String zipcode,
			String website, String comment) throws InterruptedException {
		formPage.fillData(firstName,lastName,email,phoneNumber,address,city, zipcode,website,comment);
		Thread.sleep(2000);
		formPage.clickSend();
		
	}
	
	
	@DataProvider
	public Object[][] getDataFromExcel() throws IOException {
		Object data[][]=TestUtil.getTestData();
		return data;
	}
	
	/*
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	*/
	
}
