package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorClassName {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		//##################################################################
		driver.findElement(By.className("button")).click();
		//##################################################################
		
		
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
