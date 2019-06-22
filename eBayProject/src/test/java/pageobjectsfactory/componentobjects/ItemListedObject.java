package pageobjectsfactory.componentobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjectsfactory.pageobjects.BasePage;

public class ItemListedObject extends BasePage{
	
	protected By image = By.xpath("//div[@class='s-item__image-section']/a[@href]");
	
	protected By titleLink = By.xpath("//div[contains(@class,'s-item__info')]/a[@class='s-item__link']");
	
	protected By condition = By.xpath("//div[contains(@class,'s-item__info')]/div[@class='s-item__subtitle']/span");  
	
	protected By priceRange = By.xpath("//div[contains(@class,'s-item__info')]//span[@class='s-item__price']");  
	
	protected By location = By.xpath("//div[contains(@class,'s-item__info')']//span[@class='s-item__location']");  
	
	protected By purchaseOptions = By.xpath("//div[contains(@class,'s-item__info')]//span[@class='s-item__purchase-options']"); 
	
	protected By shipping = By.xpath("//div[contains(@class,'s-item__info')]//span[@class='s-item__shipping']");  
	
	protected By numberSold = By.xpath("//div[contains(@class,'s-item__info')]//span[@class='s-item__hotness']/span[@class='BOLD NEGATIVE']");  
	
	
	private WebElement item;
	
	public ItemListedObject(WebDriver driver){
		super(driver);
	}
	
	public void clickImage() {
		click(getItem().findElement(image));
	}
	
	public void clickTitleLink() {
		click(getItem().findElement(titleLink));
	}
	
	public void setItem(WebElement item) {
		this.item = item;
	}
	
	public WebElement getItem() {
		return item;
	}
	
	public String getCondition() {
		return driver.findElement(condition).getText();
	}
	
	public String getPriceRange() {
		return driver.findElement(priceRange).getText();
	}
	
	public String getLocation() {
		return driver.findElement(location).getText();
	}
	
	public String getPurchaseOptions() {
		return driver.findElement(purchaseOptions).getText();
	}
	
	public String getShipping() {
		return driver.findElement(shipping).getText();
	}
	
	public String getNumberSold() {
		return driver.findElement(numberSold).getText();
	}
	
	
}
