package SeleniumBasicConcepts;
/*
 * 
 * HtmlunitDriver is a class
 * HtmlUnitDriver is not part of selenium web driver 3.0
 * We need to download the HtmlUnitDriver jar file.
 * Advantages :
 * 	-- No browser launching
 *  -- Very fast execution and performance also very fast
 *  -- Not suitable to for Action class -- user actions -- mouse movement --double click -- drag and drop
 * This also called Ghost driver or headless browser  
 * 
 * Different types of headless browsers : 
 * 		-- HtmlUnit Driver - java
 * 		-- PhantomJS --java script
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadLessScriptExecution {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new HtmlUnitDriver();
		
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
		System.out.println("Execution Completed");
		driver.close();
		driver.quit();
	}


}
