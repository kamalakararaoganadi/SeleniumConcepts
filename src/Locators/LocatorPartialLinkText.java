package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorPartialLinkText {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
		driver.findElement(By.partialLinkText("Forgot your passwor")).click();
		
		//driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
