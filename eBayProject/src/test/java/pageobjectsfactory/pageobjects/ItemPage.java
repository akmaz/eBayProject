package pageobjectsfactory.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjectsfactory.componentobjects.FooterComponent;
import pageobjectsfactory.componentobjects.HeaderComponent;

/**
 * Class represents a page object - an Item page on eBay
 * 
 * @author aleks
 *
 */

public class ItemPage extends BasePage {
	
	private By addToCardButtonLocator = By.xpath("//a[@id='atcRedesignId_btn']");
	private By itemTypeLocator = By.xpath("//select[@id='msku-sel-1']");
	private By priceTagLocator = By.xpath("//span[@id='prcIsum' and @itemprop='price']");
	private By goToCartLocator = By.xpath("//div[@class='app-atc-layer-redesign-content-wrapper ']/div[@class='app-atc-layer__actionRow']/a[2]");
	
	private HeaderComponent header;
	private FooterComponent footer;
	
	public ItemPage(WebDriver driver) {
		super(driver);

		header = new HeaderComponent(driver);
		footer = new FooterComponent(driver);
		
	}
	
	public void clickAddToCardButton() {
		click(driver.findElement(addToCardButtonLocator));
	}
	
	public void selectItemTypeByValue(String value) {
		Select itemTypes = new Select(driver.findElement(itemTypeLocator));
		itemTypes.selectByValue(value);
	}
	
	public void selectItemTypeByIndex(int index) {
		Select itemTypes = new Select(driver.findElement(itemTypeLocator));
		itemTypes.selectByIndex(index);
	}
	
	public void selectItemTypeByVisibleText(String text) {
		Select itemTypes = new Select(driver.findElement(itemTypeLocator));
		itemTypes.selectByVisibleText(text);
	}
	
	public double getPrice() {
		double price = Double.parseDouble(driver.findElement(priceTagLocator).getAttribute("content"));
		return price;
	}
	
	public HeaderComponent getHeader() {
		return header;
	}
	
	public FooterComponent getFooter() {
		return footer;
	}
	
	public CartPage clickGoToCart() {
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='app-atc-layer-redesign-content-wrapper ']")));

		click(driver.findElement(goToCartLocator));
		
		return new CartPage(driver);
	}


}
