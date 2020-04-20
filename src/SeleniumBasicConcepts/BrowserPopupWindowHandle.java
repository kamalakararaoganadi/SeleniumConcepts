package SeleniumBasicConcepts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserPopupWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub http://www.popuptest.com/
		System.setProperty("webdriver.chrome.driver","C:\\Work\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait for elements to load
		
		driver.get("http://www.popuptest.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Multi-PopUp Test')]")).click();
		
		Thread.sleep(3000);
		
		Set<String> handler =  driver.getWindowHandles();
		System.out.println(handler.size());
		
		Iterator<String> it =  handler.iterator();
		String parentwindow = it.next();
		System.out.println("Parent window id: "+parentwindow);
		System.out.println("parent window title: "+driver.getTitle());
        
		Thread.sleep(4000);
		
		String childwindow = it.next();
		System.out.println("Parent window id: "+childwindow);
		
		driver.switchTo().window(childwindow);
		
		Thread.sleep(4000);
		
		System.out.println("Child window title: "+driver.getTitle());
		System.out.println("Child window URL: "+driver.getCurrentUrl());
		driver.close();
		
		String childwindow2 = it.next();
		System.out.println("Parent window id: "+childwindow2);
		
		driver.switchTo().window(childwindow2);
		
		Thread.sleep(4000);
		
		System.out.println("Child window title: "+driver.getTitle());
		System.out.println("Child window URL: "+driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().window(parentwindow);
		System.out.println("parent window title: "+driver.getTitle());
		driver.quit();
	}

}
