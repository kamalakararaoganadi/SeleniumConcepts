package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorLinkText {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		//driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
		Thread.sleep(1000);
		
		String aTitle = driver.getTitle();
		String eTitle = "OrangeHRM";
		
		System.out.println("Title is: "+aTitle);
		if(aTitle.equals(eTitle))
		{
			System.out.println("The title matched");
		}
		else
		{
			System.out.println("The title is not matched");
		}
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
	}
}
