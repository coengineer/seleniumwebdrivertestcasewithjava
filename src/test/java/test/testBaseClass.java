package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testBaseClass {
	
	
	static String siteUrl="http://www.amazon.com";
	static WebDriver driver;
	static String selectedProduct;
	static boolean isThereProduct=false;
	static int favoriesCount=0;
	static int DeleteFavorite=0;
	
	
	@BeforeClass
	public static void setBrowser()
	{
//		File file = new File("C:\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
//		driver = new FirefoxDriver();
		
		File file = new File("C:chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	
	}
	@AfterClass
	public static void closeBrowser() throws InterruptedException
	{
		if(driver!=null)
		{
			Thread.sleep(5000);
			driver.quit();
		}
	}
	
	
}
