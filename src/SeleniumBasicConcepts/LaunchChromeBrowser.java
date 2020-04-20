package SeleniumBasicConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		String Title = driver.getTitle();
		System.out.println("Title: "+Title);
		String eTitle = "Google";
		if(eTitle.equals(Title))
		{
			System.out.println("The title matched");
		}
		else
		{
			System.out.println("The title is not matched");
		}
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();
	}

}
