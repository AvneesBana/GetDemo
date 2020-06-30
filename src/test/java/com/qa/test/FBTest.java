package com.qa.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.util.TestUtil;

@Listeners(com.qa.listener.TestNGListener.class)
public class FBTest extends TestUtil {

	
	public FBTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Test
	public void execute() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\selenium jars\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TestUtil.captureScreenShot(driver, "BrowserOpened");
		driver.findElement(By.id("email")).sendKeys("8130749400");
		TestUtil.captureScreenShot(driver, "EmailIdFilled");
		driver.findElement(By.id("pass")).sendKeys("@ComplementryData123&");
		TestUtil.captureScreenShot(driver, "PasswordFilled");
		driver.findElement(By.xpath("//input[@value='Log In1']")).click();
		TestUtil.captureScreenShot(driver, "LoginButtonClicked");
		  
		Thread.sleep(3000);
		TestUtil.captureScreenShot(driver, "HomePage");
		String mytitle=driver.getTitle();
		System.out.println(mytitle);
		
		
		
		driver.close();
		
	}
	
}
