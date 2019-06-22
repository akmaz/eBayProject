package pageobjectsfactory.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ItemPage extends BasePage {
	
	private By addToCardButton = By.xpath("//a[@id='atcRedesignId_btn']");
	private By itemType = By.xpath("//select[@id='msku-sel-1']");
	private By priceTag = By.xpath("//span[@id='prcIsum' and @itemprop='price']");
	
	public ItemPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickAddToCardButton() {
		click(driver.findElement(addToCardButton));
	}
	
	public void selectItemTypeByValue(String value) {
		Select itemTypes = new Select(driver.findElement(itemType));
		itemTypes.selectByValue(value);
	}
	
	public void selectItemTypeByIndex(int index) {
		Select itemTypes = new Select(driver.findElement(itemType));
		itemTypes.selectByIndex(index);
	}
	
	public void selectItemTypeByVisibleText(String text) {
		Select itemTypes = new Select(driver.findElement(itemType));
		itemTypes.selectByVisibleText(text);
	}
	
	public double getPrice() {
		double price = Double.parseDouble(driver.findElement(priceTag).getAttribute("content"));
		return price;
	}

}
