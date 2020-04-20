package POMConcepts;
/*
 * POM- page Object Model -  is a design pattern or a approach
 * Also called as Page Chaining model
 * Data Driven framework + Hybrid framework 
 * Each and every page we need create class
 * 	--	Web Objects/Web Elements(Object repository)
 * 	--	Actions/Methods or Features
 * 
 * TestBase.java is the is the Parent class for all 
 * 		-- WebDriver driver = new ChromeDriver() 
 *  com.qa.base --- package
 *   TestBase.java 	 	
 * ----------------------  				
 * |  WebDriver driver =|   
 * |  new ChromeDriver()|	   
 * |  				    |  
 * |--------------------|  
 * 
 * com.qa.pages-- package         com.qa.Tests  --package
 * Page Layer/Page library	   Test layer/Test library
 * -------------------------   ----------------------					
 * | Login page				|  |					|
 * |Web Objects/Web Elements|  |LoginPageTest.java	|
 * |Actions/Methods			|  |HomePageTest.java	|	
 * |------------------------|  |--------------------|	
 * 
 * com.qa.Config  --package  com.qa.Testdata  --package
 * Environment variables	TestData.xlsx
 * ----------------------  ----------------------					
 * |Config.properties   |  | 					|
 * | URL, UserName, 	|  |  TestData/Excel	|
 * |	Password		|  |  					|
 * |--------------------|  |--------------------|
 * 
 * com.qa.util  --package   TestOutput/Reports  --package
 *  TestUtil.java		 	TestReports
 * ----------------------  ----------------------					
 * |  Screenshot()      |  | Extent reports		|
 * |  Sendmail()	    |  |  HTML			    |
 * | CommonUtil/Generic |  |	TEstNG          |
 * | functions		    |  |	XML reports  	|
 * |--------------------|  |--------------------|
 * 
 * 
 * Different Technologies used in the project:
 * 	1. Java --  Writing Code
 *  2. Selenium web driver --- 
 *  3. TestNG -- Writing test case
 *  4. Maven -- Creating build
 *  5. Apache POI API -- To read data from excel file
 *  6. Extent report/TestNG reports --- Report generation
 *  7. Log4j API -- To generate logs
 *  8. Jenkins - CI -- Continues integration to trigger builds
 *  9. GIT - code Repository -- To maintain the code / Code check-in and check-out
 *  10.GRID - parallel testing
 *  11.Different Browsers FF/Chrome/Safari/IE
 *  12.MAC/Windows//Linux --- OS
 *  13.VM's ---- Different machines to execute test cases/Cloud machines
 *  14.SouceLabs/Browsers stack ---Cloud machines
 * 
 * 
 * @Cachelookup - we create some cache for object/elements in the web page.
 * 		-- But if page got refreshed or element changed we may get Stale exception
 * 		-- If we are confident enough that element wont change then only we should use @Cachelookup
 */

public class IntroPOM {

}
