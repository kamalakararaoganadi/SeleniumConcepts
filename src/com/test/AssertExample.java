package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AssertExample {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Work\\chromedriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait for elements to load	
		driver.get("https://www.google.com");

	}
	
	/**
	 * 
	 */
	@Test()
	public void googleTestTitleTest() {
		String title = driver.getTitle();
		System.out.println("The tile is: "+title);
		Assert.assertEquals(title, "Google","Title is not matched");
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
