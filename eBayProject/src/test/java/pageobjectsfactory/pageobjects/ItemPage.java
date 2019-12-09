package pageobjectsfactory.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	private By featuresLocator = By.xpath("//select[contains(@id,'msku-sel-')]");
	private By priceTagLocator = By.xpath("//span[@id='prcIsum' and @itemprop='price']");
	private By goToCartLocator = By.xpath("//div[@class='app-atc-layer-redesign-content-wrapper ']/div[@class='app-atc-layer__actionRow']/a[2]");
	private By finalPriceLocator = By.xpath("//div[@class='app-atc-layer-redesign-content-wrapper ']//span[@class='cc-text-spans--BOLD']");
			
	private HeaderComponent header;
	private FooterComponent footer;
	private List<WebElement> selectableFeatures;
	
	private int numberOfFeatures;
	
	public ItemPage(WebDriver driver) {
		super(driver);

		header = new HeaderComponent(driver);
		footer = new FooterComponent(driver);
		
		selectableFeatures();
		
	}
	
	public void selectableFeatures() {
		selectableFeatures = driver.findElements(featuresLocator);
		numberOfFeatures = selectableFeatures.size();
	}
	
	public void clickAddToCardButton() {
		click(driver.findElement(addToCardButtonLocator));
	}
	
	public void selectFeatureByValue(int featureNumber, String value) {
		if((featureNumber-1) <= numberOfFeatures) {
			Select itemTypes = new Select(selectableFeatures.get(featureNumber-1));
			itemTypes.selectByValue(value);
		}
	}
	
	public void selectFeatureByIndex(int featureNumber, int index) {
		if(featureNumber <= numberOfFeatures) {
			System.out.println(".......");
			Select itemTypes = new Select(selectableFeatures.get(featureNumber-1));
			itemTypes.selectByIndex(index);
		}
	}
	
	public void selectFeatureByVisibleText(int featureNumber, String text) {
		if((featureNumber-1) <= numberOfFeatures) {
			Select itemTypes = new Select(selectableFeatures.get(featureNumber-1));
			itemTypes.selectByVisibleText(text);
		}
	}
	
	public double getFinalPrice() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='app-atc-layer-redesign-content-wrapper ']")));

		double price = Double.parseDouble(driver.findElement(finalPriceLocator).getText().substring(1));
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
