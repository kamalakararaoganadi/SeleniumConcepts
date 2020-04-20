package SeleniumBasicConcepts;
/*
 * Frames can be handled in different ways
 * 	1. By Index
 * 	2. By Name or Id
 * 	3. By Web Element  ---------- driver.switchTo().frame(WebElement);
 * 
 * To switch to Main frame 
 * 	driver.switchTo().parentFrame(); or driver.switchTo().defaultContent();
 */
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandling {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		FramesHandling obj = new FramesHandling();
		obj.Handling_Frames();
		
		
	}
	
	public void Handling_Frames() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Work\\chromedriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		
		FramesHandling obj = new FramesHandling();
		obj.switchToFrame("a077aa5e");
		System.out.println(driver.findElement(By.xpath("//html//body//a//img")).getText());
		driver.findElement(By.xpath("//html//body//a//img")).click();
		System.out.println("iframe is clicked");
		driver.quit();
	}
	
	
	//********** Frames handling by index ******************
	public void switchToFrame(int frame) {
		try {
			driver.switchTo().frame(frame);
			System.out.println("Navigated to frame with id " + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + frame
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with id " + frame
					+ e.getStackTrace());
		}
	}
	
	
	public void LoopThroughAllTheIframes() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Work\\chromedriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total no of i frames: "+size);
	    for(int i=0; i<=size; i++){
	    	driver.switchTo().frame(i);
	    	int total=driver.findElements(By.xpath("html/body/a/img")).size();
	    	System.out.println(total);
	    	driver.switchTo().defaultContent();
	    }
	    driver.quit();
	}
	
	
	//********** Frames handling by id/name ******************
	public void switchToFrame(String frame) {
		try {
			driver.switchTo().frame(frame);
			System.out.println("Navigated to frame with id " + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + frame
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with id " + frame
					+ e.getStackTrace());
		}
	}
	
	
	
	/* public void switchToFrame(WebElement frameElement) {
		try {
			if (isElementPresent(frameElement)) {	
				driver.switchTo().frame(frameElement);
				System.out.println("Navigated to frame with element "+ frameElement);
			} else {
				System.out.println("Unable to navigate to frame with element "+ frameElement);
			}
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with element " + frameElement + e.getStackTrace());
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + frameElement + "is not attached to the page document" + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with element " + frameElement + e.getStackTrace());
		}
	}*/
	
	
	public boolean isElementPresent(By by) {
	    try {
	      driver.findElements(by);
	      return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	      return false;
	    }
	}
	
	
	public void switchToFrame(String ParentFrame, String ChildFrame) {
		try {
			driver.switchTo().frame(ParentFrame).switchTo().frame(ChildFrame);
			System.out.println("Navigated to innerframe with id " + ChildFrame
					+ "which is present on frame with id" + ParentFrame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + ParentFrame
					+ " or " + ChildFrame + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to innerframe with id "
					+ ChildFrame + "which is present on frame with id"
					+ ParentFrame + e.getStackTrace());
		}
	}
	
	public void switchtoDefaultFrame() {
		try {
			driver.switchTo().defaultContent();
			System.out.println("Navigated back to webpage from frame");
		} catch (Exception e) {
			System.out
					.println("unable to navigate back to main webpage from frame"
							+ e.getStackTrace());
		}
	}
	

}
