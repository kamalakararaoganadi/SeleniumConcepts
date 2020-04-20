package SeleniumBasicConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor_HighlightElements {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		WebElement login_Button =  driver.findElement(By.id("btnLogin"));
		flash(login_Button, driver);
		
		drawboarder(login_Button, driver);
		
		//take screenshot 
		TakeScreenShot.takeSnapShot(driver, "C:\\Work\\ScreenShots\\test1.jpeg");
		
		//Generate alert method
		generateAlert("This a generated alert used for logging in the log file", driver);
		
		driver.switchTo().alert().accept();
		
		driver.switchTo().parentFrame();
		
		Thread.sleep(1000);
		
		clickElementByJS(login_Button, driver);		
		//login_Button.click();
		
		refreshBrowserByJS(driver);
		//driver.navigate().refresh();
		
		//get the title by js 
		System.out.println(getTitleByJS(driver)); 
		
		//get the inner text 
		System.out.println(getInnerTextByJS(driver));
		
		//Scrolls completely down to the web page
		//scrollPageDownByJS(driver);
		
		//footer
		WebElement footer_id = driver.findElement(By.id("footer"));
		scrollInViewByJS(footer_id, driver);
		
		
		
		Thread.sleep(1000);
		driver.quit();
		
      
	}
	
	public static void flash(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0; i< 10; i++)
		{
			changecolor("rgb(0,200,0)",element,driver);
			changecolor(bgcolor,element,driver);
		}
			
	}
	
	public static void changecolor(String color, WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void drawboarder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
	}
	
	public static void generateAlert(String message, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
			
	}
	
	public static void refreshBrowserByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0);");
			
	}
	
	public static String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
			
	}
	
	public static String getInnerTextByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
			
	}
	
	public static void scrollPageDownByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
			
	}
	
	public static void scrollInViewByJS(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
			
	}
	
	
	public static void dateSetter(WebElement element,WebDriver driver,String dateval)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateval+"');",element);
			
	}

}
