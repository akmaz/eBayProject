package pageobjectsfactory.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageobjectsfactory.componentobjects.FooterComponent;
import pageobjectsfactory.componentobjects.HeaderComponent;

/**
 * Class represents a page object - Main eBay page
 * @author aleks
 *
 */

public class MainPage extends BasePage {
	
	private static final String URL = "https://www.ebay.com/";
	private static final String PAGE_TITLE = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
	
	private HeaderComponent header;
	private FooterComponent footer;
	
		
	public MainPage(WebDriver driver) {
		super(driver);
		
		header = new HeaderComponent(driver);
		footer = new FooterComponent(driver);
	}
	
	public void openMainPage() {
		driver.get(URL);
	}
	
	public void assertTitle() {
		assertEquals(PAGE_TITLE, getTitle());
	}
	
	public void assertUrl() {
		assertUrl(URL);
	}
	
	public HeaderComponent getHeader() {
		return header;
	}
	
	public FooterComponent getFooter() {
		return footer;
	}

}
