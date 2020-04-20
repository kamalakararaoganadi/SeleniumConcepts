package SeleniumBasicConcepts;

/* Generally some times we need to find the total links available on the web page, so we can use this concept
 * And we can get the text of each link
 * we can use findElements(By.tagName("a")) // a- since we know that all the links in the web page will be represented by <a> html tag name
 * Return type is List
 * html tag a - to get all the ***links*** in the web page
 * html tag input - to get all the ***input_fields*** in the web page
 * html tag buttons - to get all the ***buttons*** in the web page
 */


import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class FindElementsConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Work\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.ebay.com/");
		
		
		//Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait for elements to load
		
		
		List <WebElement> linkList =  driver.findElements(By.tagName("a"));
		System.out.println(linkList.size());
		
		for(int i = 0; i<linkList.size();i++)
		{
			System.out.println(i+": "+linkList.get(i).getText());
		}
		
		driver.quit();

	}

}
