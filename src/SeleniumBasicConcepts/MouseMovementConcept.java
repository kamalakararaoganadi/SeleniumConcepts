package SeleniumBasicConcepts;


/*
 * Mouse over on the main menu and select the sub menu item
 * Mouse Movement -- is done by actions class
 * Actions action = new Actions(driver);
 * action.moveToElement(driver.findElement(By.linkText("Manual"))).build().perform();
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Work\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://artoftesting.com/samplesiteforselenium");
		
		
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.linkText("Manual"))).build().perform();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Manual Testing Tutorial")).click();
		
		driver.quit();

	}

}
