package SeleniumBasicConcepts;


/*
 * While handling alerts 
 * 1. Alert alert = driver.switchTo().alert(); //switch to alerts from browser
 * 2. alert.accept(); //to click on the OK Button **************** driver.switchTo().alert().accept(); this is also correct;
 * 3. alert.dismiss(); // to Click on the cancel button ********** driver.switchTo().alert().dismiss();
 * 4. alert.sendKeys("Text"); //to Enter text in the alert/PopUp window *****************  driver.switchTo().alert().sendKeys("Text");
 * 5. alert.getText(); //to get text from alert/pop-up ************ driver.switchTo().alert().getText();
 * 
 * 6. driver.findElement(By.name("file-upload")).sendKeys("C:\\Work\\SampleFile.txt");
 * 		-- Important thing type should be file while inspect that element
 * 		-- Here by name is used use accordingly which ever the locator available;
 * 		-- While uploading file don't click on browse button to select the required file
 * 		-- Directly the file will be upload if we use send keys
 */

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;







public class AlertsHandling_PopUps {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		
		AlertsHandling_PopUps obj = new AlertsHandling_PopUps();
			
		
		//obj.Handle_ConfirmationPopUp_And_SimplePopUp();
		
		obj.Handle_FileUpload_PopUP();
		
		//obj.verifySearchInNewWindow();
		
		

	}

	
	public void Handle_ConfirmationPopUp_And_SimplePopUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		driver.findElement(By.name("cusid")).sendKeys("102345");
		driver.findElement(By.name("submit")).click();
		
		//**************** Switching to PopUp window ********************
		Alert alert = driver.switchTo().alert();
		
		
		//**************** Handling Confirmation alert/PopUp OK button ********************
		System.out.println(alert.getText()); //to get text from alert/pop-up
		alert.accept(); //to click on the OK Button
		System.out.println("OK is clicked in the ");
		
		
		//**************** Handling Simple alert/PopUp ********************
		System.out.println(alert.getText()); //to get text from alert/pop-up
		alert.accept(); //To click on the OK button
		System.out.println("OK is clicked in the ");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//**************** Handling Confirmation alert/PopUp Cancel button ********************
		driver.findElement(By.name("cusid")).sendKeys("102345");
		driver.findElement(By.name("submit")).click();
		System.out.println("For cancel operation : "+alert.getText()); //to get text from alert/pop-up
		alert.dismiss(); // to Click on the cancel button
		System.out.println("OK is clicked in the ");
		driver.quit();
		
	}
	
    //*****************File upload*************************
	public void Handle_FileUpload_PopUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		driver.findElement(By.name("upfile")).sendKeys("C:\\Work\\SampleFile.txt");
		driver.quit();
	}
	
	
	
	public void verifySearchInNewWindow() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://linkedin.com/");
		driver.manage().window().maximize();
		String mainHandle = driver.getWindowHandle();
		
		//Wait for the element to be present
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cust-svc-link")));
		driver.findElement(By.linkText("Help Center")).click();
		
		//Switch to new window and verify the title
		waitForNewWindowAndSwitchToIt(driver);
		String newTitle = getCurrentWindowTitle();
		if(newTitle.equals("LinkedIn Help Center") == true);
		 System.out.println("text matched");
		
		//Verify the text present on the page
		//String textOnpage=driver.findElement(By.cssSelector(".welcome")).getText().trim();
		//if(textOnpage.equals("Welcome!") == true);
		//System.out.println("text matched");
		
		//Verify search text on the page
		String searchText="Frequently Asked Questions";
		WebElement searchInputBox=driver.findElement(By.id("desktop-hero-search-query"));
		searchInputBox.sendKeys(searchText);
		
		WebElement searchButton = driver.findElement(By.xpath("//div[@class='hero-search__search-form']//li-icon[contains(@class,'svg-icon')]"));
		searchButton.click();
		
		WebElement resultedElement = driver.findElement(By.xpath("//a[contains(text(),'Sponsored Jobs - Frequently Asked Questions')]"));
		String resultedText = resultedElement.getText().trim();
		System.out.println(resultedText);
		if(resultedText.contains(searchText) == true);
			System.out.println("Search successfull");
		
		closeAllOtherWindows(driver, mainHandle);
		driver.quit();
	}
	
	public static void waitForNewWindowAndSwitchToIt(WebDriver driver) throws InterruptedException {
        String cHandle = driver.getWindowHandle();
        String newWindowHandle = null;
        Set<String> allWindowHandles = driver.getWindowHandles();
        
        //Wait for 20 seconds for the new window and throw exception if not found
        for (int i = 0; i < 20; i++) {
            if (allWindowHandles.size() > 1) {
                for (String allHandlers : allWindowHandles) {
                    if (!allHandlers.equals(cHandle))
                    	newWindowHandle = allHandlers;
                }
                driver.switchTo().window(newWindowHandle);
                break;
            } else {
                Thread.sleep(1000);
            }
        }
        if (cHandle == newWindowHandle) {
            throw new RuntimeException(
                    "Time out - No window found");
        }
    }
	
	public static boolean closeAllOtherWindows(WebDriver driver, String openWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.close();
			}
		}
		
		driver.switchTo().window(openWindowHandle);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}
	
	
	public static String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}
	
	public static String getMainWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}
}

