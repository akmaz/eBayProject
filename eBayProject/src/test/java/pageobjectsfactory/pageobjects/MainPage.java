package pageobjectsfactory.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageobjectsfactory.componentobjects.FooterObject;
import pageobjectsfactory.componentobjects.HeaderObject;

/**
 * Class represents a page object - Main eBay page
 * @author aleks
 *
 */

public class MainPage extends BasePage {
	
	private static final String URL = "https://www.ebay.com/";
	private static final String PAGE_TITLE = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
	
	private HeaderObject header;
	private FooterObject footer;
	
		
	public MainPage(WebDriver driver) {
		super(driver);
		
		header = new HeaderObject(driver);
		footer = new FooterObject(driver);
	}
	
	public void openMainPage() {
		driver.get(URL);
	}
	
	public void assertTitle() {
		assertEquals(PAGE_TITLE, getTitle());
	}
	
	public void assertUrl() {
		assertEquals(URL, getUrl());
	}
	
	public HeaderObject getHeader() {
		return header;
	}

}
