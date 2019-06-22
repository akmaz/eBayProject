package pageobjectsfactory.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageobjectsfactory.componentobjects.FooterObject;
import pageobjectsfactory.componentobjects.HeaderObject;

/**
 * Class represents a page object - Cart page
 * 
 * @author aleks
 *
 */

public class CartPage extends BasePage {

	private static final String URL = "https://cart.ebay.com/";
	private static final String PAGE_TITLE = "Shopping cart";
	
	private HeaderObject header;
	private FooterObject footer;
	
	@FindBy(xpath = "//a[@data-test-id='start-shopping']")
	private WebElement startShoppingButton;
	
	@FindBy(xpath = "//a[@data-test-id='sign-in']")
	private WebElement signInButton;
	
	@FindBy(xpath = "//a[@data-test-id='SURVEY_LINK']")
	private WebElement sendUsYourCommentsLink;
	
	@FindBy(xpath = "//div[@class='empty-cart']")
	private List<WebElement> emptyCard;
	
		
	public CartPage(WebDriver driver) {
		super(driver);
		
		header = new HeaderObject(driver);
		footer = new FooterObject(driver);
	}
	
	public void openCardPage() {
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
	
	public MainPage clickStartShoppingButton() {
		click(startShoppingButton);
		
		return new MainPage(driver);
	}
	
	public void clickSignInButton() {
		click(signInButton);
	}
	
	public void clickSendUsYourCommentsLink() {
		click(sendUsYourCommentsLink);
	}
	
	public void checkIfCartEmpty() {
		assertEquals(1, emptyCard.size());
	}

}