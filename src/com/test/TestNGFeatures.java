package com.test;

/*
 * IF the "loginTest" is failed then the dependent test cases will be failed
 * In the below example "homePageTest" will execute only and only if the "loginTest" is passed
 */
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestNGFeatures {
	WebDriver driver;
	
	@Test(priority = 3, groups = "Module2")
	public void loginTest() {
		System.out.println("loginTest");
	}
	
	@Test(priority = 2, groups = "Module3",dependsOnMethods = "loginTest")
	public void homePageTest() {
		System.out.println("HomePageTest");
	}
}
