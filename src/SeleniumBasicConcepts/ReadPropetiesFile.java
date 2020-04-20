package SeleniumBasicConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropetiesFile {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		
		FileInputStream ip = new FileInputStream("C:\\Users\\kamalakararao.ganadi\\eclipse-workspace\\SeleniumConcepts\\src\\SeleniumBasicConcepts\\config.properties");
		
		prop.load(ip);
		
		System.out.println(prop.getProperty("name"));
		
		System.out.println(prop.getProperty("age"));
		
		String url = prop.getProperty("URL");
		System.out.println(url);
		
		String browserName = prop.getProperty("browser");
		
		System.out.println(browserName);
		
		
		if(browserName.equals("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverexepath"));
			driver = new ChromeDriver();
			
			
		} else if(browserName.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriverexepath")); 
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		
        driver.findElement(By.xpath(prop.getProperty("search_xpath"))).sendKeys(prop.getProperty("valuetoenter"));
        
        driver.findElement(By.xpath(prop.getProperty("search_xpath"))).sendKeys(Keys.ENTER);
        
        driver.quit();
	}

}
