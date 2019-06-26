package pageobjectsfactory.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import pageobjectsfactory.componentobjects.FooterComponent;
import pageobjectsfactory.componentobjects.HeaderComponent;
import pageobjectsfactory.componentobjects.ItemInCartComponent;

/**
 * Class represents a page object - Cart page
 * 
 * @author aleks
 *
 */

public class CartPage extends BasePage {

	private static final String URL = "https://cart.payments.ebay.com/";
	private static final String PAGE_TITLE = "Shopping cart";
	
	private HeaderComponent header;
	private FooterComponent footer;
	
	private List<ItemInCartComponent> itemsInCart;
	private By itemsInCartLocator = By.xpath("//div[@data-test-id='cart-bucket']");
	private By pageAlertLocator = By.xpath("//div[@data-test-id='page-alerts']/div");
	
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
		
		header = new HeaderComponent(driver);
		footer = new FooterComponent(driver);
		
		locateItemsInCart();
	}
	
	public void openCardPage() {
		driver.get(URL);
	}
	
	public void locateItemsInCart() {
		List<WebElement> itemsInCartElements = driver.findElements(itemsInCartLocator);
		itemsInCart = new ArrayList<ItemInCartComponent>();
		
		if(itemsInCartElements.size()!=0) {
			for(int i=0; i<itemsInCartElements.size() ; i++) {
				ItemInCartComponent itemInCart = new ItemInCartComponent(driver);
				itemInCart.setItem(itemsInCartElements.get(i));
				itemsInCart.add(itemInCart);
			}
		}
	}
	

	public ItemInCartComponent getItem(int index) {
		return itemsInCart.get(index);
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
	
	public MainPage clickStartShoppingButton() {
		click(startShoppingButton);
		
		return new MainPage(driver);
	}
	
	public void clickSignInButton() {
		click(signInButton);
	}
	
	public CartFeedbackPage clickSendUsYourCommentsLink() {
		click(sendUsYourCommentsLink);
		
		return new CartFeedbackPage(driver);
	}
	
	public void checkIfCartEmpty() {
		assertEquals(1, emptyCard.size());
	}
	
	public void checkItemRemoved() {
		int num = driver.findElements(pageAlertLocator).size();
		
		Assert.assertEquals(num, 1);
	}

}