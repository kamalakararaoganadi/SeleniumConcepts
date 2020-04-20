package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
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
	
	@Test(priority = 1,groups = "Title")
	public void googleTestTitleTest() {
		String title = driver.getTitle();
		System.out.println("The tile is: "+title);
	}
	
	@Test(priority = 3, groups = "Module2")
	public void googleLogoTest() {
		driver.findElement(By.xpath("//body[@id='gsr']/div[@id='viewport']/div[@id='main']/span[@id='body']/center/div[@id='lga']/div[@id='hplogo']/a/img[1]"));
	}
	
	@Test(priority = 2, groups = "Module3")
	public void mailLinkTest() {
		driver.findElement(By.linkText("Gmail"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
