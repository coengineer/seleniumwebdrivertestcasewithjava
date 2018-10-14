package test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class testPageObjectModel extends testBaseClass {
	
	public WebElement findByName(String _name)
	{
		WebElement element =driver.findElement(By.name(_name));
		return element;
	}
	public WebElement findSelector(String _selectorname)
	{
		WebElement element =driver.findElement(By.cssSelector(_selectorname));
		return element;
	}
	public WebElement findByClassName(String _className)
	{
		WebElement element=driver.findElement(By.className(_className));
		return element;
		
	}
	
	public WebElement findByXpath(String _xpathname)
	{
		WebElement element=driver.findElement(By.xpath(_xpathname));
		return element;
	}
	
	public WebElement findById(String _id)
	{
		WebElement element=driver.findElement(By.id(_id));
		return element;
	}
	
	public List<WebElement> findListByXpath(String _listxpathname)
	{
		List<WebElement> element = driver.findElements(By.xpath(_listxpathname));
	    
	    return element;
	}
	
	public ExpectedCondition<WebElement> isClickableById(String _clickId ) 
	{
		ExpectedCondition<WebElement> clickable=ExpectedConditions.elementToBeClickable((By.id(_clickId))); 
		return clickable;
	
	}
	
	public ExpectedCondition<WebElement> isClickableByClassName(String _clickClassName ) 
	{
		ExpectedCondition<WebElement> clickable=ExpectedConditions.elementToBeClickable((By.className(_clickClassName))); 
		return clickable;
	
	}
	
	public ExpectedCondition<WebElement> isClickableByXpath(String _xpathclickName ) 
	{
		ExpectedCondition<WebElement> clickable=ExpectedConditions.elementToBeClickable((By.xpath(_xpathclickName))); 
		return clickable;
	
	}
	
	public String getElementTextByXpath(String name){
		return driver.findElement(By.xpath(name)).getText();
	}
	

public void waitForPageLoad() {
	
	@SuppressWarnings("deprecation")
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			//Wait for the condition
		       .withTimeout(30, TimeUnit.SECONDS) 
		         // which to check for the condition with interval of 5 seconds. 
		       .pollingEvery(5, TimeUnit.SECONDS) 
		     //Which will ignore the NoSuchElementException
		       .ignoring(NoSuchElementException.class);
	
	
	}
	
	
	
	
	
	
	

}
