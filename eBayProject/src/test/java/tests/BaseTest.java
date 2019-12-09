package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Class contains basic functionalities and variables of all test classes
 * Such as a WebDriver instance, startBrowser(), closeBrowser()
 * 
 * All the other test classes extend this class
 * 
 * @author aleks
 *
 */

public class BaseTest {

	public WebDriver driver;
	
	@BeforeClass
	public void startBrowser() {
		/*
		 * if needed, change to a different driver for Mac or Linux
		 */
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/ChromeDriver/chromedriver_win32/driver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
