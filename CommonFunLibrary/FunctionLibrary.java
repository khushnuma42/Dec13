package CommonFunLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PropertyFileUtil;
import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

public class FunctionLibrary {

	
		public static WebDriver driver;
		public static WebDriver startBrowser() throws Throwable{
			if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("chrome"))
			{
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium_FrameWorks\\ERP_Accounting\\CommonDrivers\\chromedriver.exe");
			 driver=new ChromeDriver();
			
			}
			else if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("firefox"))
			{
			driver=new FirefoxDriver();	
			}
			else
			{
				System.out.println("Browser is not matching");
			}
			return driver;
	}
		//method for open app
		public static void openApplication(WebDriver driver) throws Throwable
		{
		driver.get(PropertyFileUtil.getValueForKey("Url"));	
		driver.manage().window().maximize();
		}
		//method for wait for element
		//waittime for accessing testdata
		public static void waitForElement(WebDriver driver,String locatortype,String locatorvalue,String waittime)
		{
		WebDriverWait mywait=new WebDriverWait(driver,Integer.parseInt(waittime));
		if(locatortype.equalsIgnoreCase("id"))
		{
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));	
		}
		else if(locatortype.equalsIgnoreCase("name"))
		{
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
			
		}
		else if(locatortype.equalsIgnoreCase("xpath"))
		{
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
		}
		else
		{
			System.out.println("unable to execute wait for element method");
		}
		}
      //method for type action
		public static void typeAction(WebDriver driver,String locatortype,String locatorvalue,String testdata)
		{
			if(locatortype.equalsIgnoreCase("id"))
			{
			driver.findElement(By.id(locatorvalue)).clear();
			driver.findElement(By.id(locatorvalue)).sendKeys(testdata);
			}
			else if(locatortype.equalsIgnoreCase("name"))
			{
				driver.findElement(By.name(locatorvalue)).clear();
				driver.findElement(By.name(locatorvalue)).sendKeys(testdata);	
			}
			else if(locatortype.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath(locatorvalue)).clear();
				driver.findElement(By.xpath(locatorvalue)).sendKeys(testdata);
			}
			else
			{
				System.out.println("unable to execute type action method");
			}
			
		}
		//method for click action
		public static void clickAction(WebDriver driver,String locatortype,String locatorvalue)
		{
			if(locatortype.equalsIgnoreCase("id"))
			{
			driver.findElement(By.id(locatorvalue)).click();
			
			}
			else if(locatortype.equalsIgnoreCase("name"))
			{
				driver.findElement(By.name(locatorvalue)).click();
				
			}
			else if(locatortype.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath(locatorvalue)).click();
				
			}
			else
			{
				System.out.println("unable to execute click action method");
			}
			
			
		}
		//method for close
		public static void closeBrowser(WebDriver driver)
		{
			driver.close();
		}
		
}
		