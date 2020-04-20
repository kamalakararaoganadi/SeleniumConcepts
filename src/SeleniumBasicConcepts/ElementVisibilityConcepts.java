package SeleniumBasicConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityConcepts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/radio.html");
		
	
		WebElement checkBox =  driver.findElement(By.id("vfb-6-0"));
		boolean b1 = checkBox.isDisplayed();
		System.out.println("checkbox isDisplayed value :"+b1);
		//login_Button.click();
		
		
		boolean b2 = checkBox.isEnabled();
		System.out.println("checkbox isEnabled value :"+b2);
		
		checkBox.click();
		boolean b3 = checkBox.isSelected();
		System.out.println("After Selecting checkbox isSelected value : "+b3);
		
		checkBox.click();
		Thread.sleep(1000);
		boolean b4 = checkBox.isSelected();
		System.out.println("After deSelecting checkbox isSelected value : "+b4);;
		
		driver.quit();

	}

}
