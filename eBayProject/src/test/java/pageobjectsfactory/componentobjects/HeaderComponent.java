package pageobjectsfactory.componentobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageobjectsfactory.pageobjects.BasePage;
import pageobjectsfactory.pageobjects.CartPage;
import pageobjectsfactory.pageobjects.SearchPage;

/**
 * Class represents a component object - Header of the eBay page
 * @author aleks
 *
 */

public class HeaderComponent extends BasePage{
	
	
	@FindBy(xpath="//span[@id='gh-ug']/a")
	private WebElement signInLink;
	
	@FindBy(xpath="//span[@id='gh-ug-flex']/a")
	private WebElement registerLink;
	
	@FindBy(xpath="//li[@id='gh-p-1']/a")
	private WebElement dailyDealsLink;
	
	@FindBy(xpath="//li[@id='gh-p-4']/a")
	private WebElement giftCartsLink;
	
	@FindBy(xpath="//li[@id='gh-p-3']/a")
	private WebElement helpContactLink;
	
	@FindBy(xpath="//a[@id='gh-doodleS']")
	private WebElement funFundsLink;
	
	@FindBy(xpath="//li[@id='gh-p-2']/a")
	private WebElement sellLink;
	
	@FindBy(xpath="//li[@id='gh-eb-My']//a[.=' My eBay']")
	private WebElement myEbayLink;
	
	@FindBy(xpath="//li[@id='gh-eb-Alerts']")
	private WebElement bellIcon;
	
	@FindBy(xpath="//li[@id='gh-cart']")
	private WebElement cartIcon;
	
	@FindBy(xpath="//a[@id='gh-la']")
	private WebElement eBayIcon;
	
	@FindBy(xpath="//button[@id='gh-shop-a']")
	private WebElement shopByCategoryLink;
	
	@FindBy(xpath="//input[@id='gh-ac']")
	private WebElement searchBox;
	
	@FindBy(xpath="//select[@id='gh-cat']")
	private WebElement allCategories;
	
	@FindBy(xpath="//input[@id='gh-btn']")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[@id='gh-as-a']")
	private WebElement advancedLink;
	
	
	public HeaderComponent(WebDriver driver) {
		super(driver);
		
	}
	
	public void clickSignInLink() {
		click(signInLink);
	}

	public void clickRegisterLink() {
		click(registerLink);
	}

	public void clickDailyDealsLink() {
		click(dailyDealsLink);
	}

	public void clickGiftCardslsLink() {
		click(giftCartsLink);
	}
	
	public void clickHelpContactLink() {
		click(helpContactLink);
	}

	public void clickFunFundsLink() {
		click(funFundsLink);
	}

	public void clickSellLink() {
		click(sellLink);
	}

	public void clickMyEbayLink() {
		click(myEbayLink);
	}
	
	public void clickBellIcon() {
		click(bellIcon);
	}
	
	public CartPage clickCartIcon() {
		click(cartIcon);
		
		return new CartPage(driver);
	}

	public void clickeBayIcon() {
		click(eBayIcon);
	}
	
	public void clickShopByCategoryLink() {
		click(shopByCategoryLink);
	}
	
	public void clickAllCategories() {
		click(allCategories);
	}
	
	public SearchPage clickSearchButton() {
		click(searchButton);
		
		return new SearchPage(driver);
	}
	
	public void clickAdvancedLink() {
		click(advancedLink);
	}
	
	public void typeInSearch(String text) {
		write(searchBox, text);
	}
	

}
