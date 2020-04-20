package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * TestNG- Its a unit testing framework
 * TDD Framework - Test Driven Development 
 * Purpose - Design test cases in systematic ways.
 * 	--	HTML REPORTS
 * 	-- 	Data providers
 * 	--	grouping
 * 	--	different annotations
 * 	--	Dependency
 * 	-- 	Properties/ 
 * 
 *  Name: TestNG Eclipse

*	Location: dl.bintray.com/testng-team/testng-eclipse-release/
*
@BeforeSuite ---- System setup for chrome browser
@BeforeTest --- launchbrowser
@BeforeClass ---- login

@BeforeMethod ---- enterurl
@Test -- testgoogletitle
@AfterMethod --- logout

@BeforeMethod ---- enterurl
@Test --- testgoogletitle2
@AfterMethod --- logout

@AfterClass --- closebrowser
@AfterTest --- deleteAllcoockies

 * 
 */

public class Concept {

	
	//Preconditions starts with @before
	@BeforeSuite
	public void setup() {
		System.out.println("@BeforeSuite ---- System setup for chrome browser");
	}
	
	@BeforeTest
	public void launchbrowser() {
		System.out.println("@BeforeTest --- launchbrowser");
	}
	
	
	@BeforeClass
	public void login() {
		System.out.println("@BeforeClass ---- login");
	}
	
	@BeforeMethod
	public void enterurl() {
		System.out.println("@BeforeMethod ---- enterurl");
	}
	
	/*
	 * @BeforeMethod
	 * @Test -1
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test -2
	 * @AfterMethod
	 */
	
	//test case -- starting with @Test
	@Test
	public void testgoogletitle() {
		System.out.println("@Test -- testgoogletitle");
	}
	
	@Test
	public void testgoogletitle2() {
		System.out.println("@Test --- testgoogletitle2");
	}
	
	//post condition -- starting with @after	
	@AfterMethod
	public void logout() {
		System.out.println("@AfterMethod --- logout");
	}
	
	
	@AfterClass
	public void closebrowser() {
		System.out.println("@AfterClass --- closebrowser");
	}
	
	@AfterTest
	public void deleteAllcoockies() {
		System.out.println("@AfterTest --- deleteAllcoockies");
	}
	
	@AfterSuite
	public void generateReport() {
		System.out.println("@AfterSuite ---- generateReport");
	}

}
