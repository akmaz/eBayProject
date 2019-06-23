package pageobjectsfactory.componentobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjectsfactory.pageobjects.BasePage;

/**
 * Class represents a component object - an item added to the cart in the Cart Page
 * 
 * @author aleks
 *
 */

public class ItemInCartComponent extends BasePage {
	
	private By titleLinkLocator = By.xpath("//a[@data-test-id='cart-item-link']");
	
	private By quantityLocator = By.xpath("//select[@data-test-id='qty-dropdown']");
	
	private By priceLocator = By.xpath("//div[@class='item-price']//span");
	
	private By saveForLaterLinkLocator = By.xpath("//button[@data-test-id='cart-to-sfl']");

	private By removeLinkLocator = By.xpath("//button[@data-test-id='cart-remove-item']");
	
	public ItemInCartComponent(WebDriver driver) {
		super(driver);
		
	}
	
	private WebElement item;
	
	public void setItem(WebElement item) {
		this.item = item;
	}
	
	public double getPrice() {
		double price = Double.parseDouble(read(item.findElement(priceLocator)).substring(1));
		
		return price;
	}
	
	public void removeItem() {
		click(driver.findElement(removeLinkLocator));
	}
}
