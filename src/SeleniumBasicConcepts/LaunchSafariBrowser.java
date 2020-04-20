package SeleniumBasicConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LaunchSafariBrowser {

	public static void main(String[] args) {
		
		//No need to set any exe path for safari browser 
		WebDriver driver = new SafariDriver();
		driver.get("http://www.google.com");

	}

}
