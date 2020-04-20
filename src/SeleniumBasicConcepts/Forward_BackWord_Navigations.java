package SeleniumBasicConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Forward_BackWord_Navigations {
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Work\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		
		//Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait for elements to load
		
		driver.get("https://www.google.com/");
		Thread.sleep(1000);
		driver.navigate().to("https://www.amazon.com/");
		
		//back and forward button simulations
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		driver.navigate().refresh(); //refresh the page
		driver.quit();

	}
}
