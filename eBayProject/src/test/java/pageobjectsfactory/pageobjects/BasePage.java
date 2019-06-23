package pageobjectsfactory.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Class contains common methods for other page objects
 * Such as click(), sendKeys(), ...
 * 
 * @author aleks
 *
 */

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 25);
		
		PageFactory.initElements(driver, this);
	}
	
	public void waitVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public void click(WebElement element) {
		waitVisibility(element);
		
		element.click();
	}
	
	public void write(WebElement element, String text) {
		waitVisibility(element);
		
		element.sendKeys(text);
	}
	
	public String read(WebElement element) {
		waitVisibility(element);
		
		return element.getText();
	}
	
	public void assertEquals(String text, WebElement element) {
		waitVisibility(element);
		
		Assert.assertEquals(read(element), text);
		
	}
	
	public void assertEquals(String text, String text2) {
		Assert.assertEquals(text, text2);	
	}
	
	public void assertEquals(int x, int y) {
		Assert.assertEquals(x, y);	
	}
	
	public void assertUrl(String url) {
		
		Assert.assertEquals(getUrl(), url);
	}
	
	public void assertUrlContains(String text) {
		
		Assert.assertTrue(getUrl().contains(text));
	}
	
	public void assertCorrectTitle(String title) {
		
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	public void assertTrue(boolean condition) {
		Assert.assertTrue(condition);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}


	
}
