package SeleniumBasicConcepts;


/* Absolute xpath: From parent to web element 
 * 		Example: /html[1]/body[1]/header[1]/div[1]/ul[1]/li[1]/span[1]/a[1]
 * 		Disadvantages: 1. Not reliable 2. it can be changed at any time 3.Performance issue.
 *
 * Relative x path:
 * Dynamic id example when to use contains in Xpath.
 * id = test_123;
 * next time when we load id may change to id = test_234;
 * next time  id changed to id = test_435;
 * contains:   Now we need to use contains in the xpath: "//input[contains(@id,'test_')]"  //input is the html tag
 * starts-with:   we can use starts-with in xpath: "//input[starts-with(@id,'test_')]" 
 * ends-with:   1st time: id = 123_test_  
 * 				2nd time: id = 453_test_ ;
 * 				we have similar method in xpath: "//input[ends-with(@id,'test_')]" 
 * 
 * Xpath for Links: <a> html tag: 
 *  	"//a[contains(text(),'Sign in')]"
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Work\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait for elements to load
		
		driver.get("https://www.ebay.com/");
		
		driver.findElement(By.xpath("//input[@label='Search for anything']")).sendKeys("selenium");
		
		driver.findElement(By.xpath("//input[@id = 'gh-ac']")).sendKeys(" JAVA");
		
		driver.findElement(By.xpath("//input[contains(@label,'Search for anything')]")).sendKeys(" learing");
		

		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		
		
		driver.quit();
		


	}

}
