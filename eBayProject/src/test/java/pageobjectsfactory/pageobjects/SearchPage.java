package pageobjectsfactory.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageobjectsfactory.componentobjects.FooterComponent;
import pageobjectsfactory.componentobjects.HeaderComponent;
import pageobjectsfactory.componentobjects.ItemListedComponent;
import pageobjectsfactory.componentobjects.LeftBarComponent;

/**
 * Class represents a page object - search page on eBay
 * 
 * @author aleks
 *
 */

public class SearchPage extends BasePage {

	private static final String PART_OF_PAGE_TITLE = " | eBay";
	
	private HeaderComponent header;
	private FooterComponent footer;
	private LeftBarComponent leftBar;
	
	private By itemsListedLocator = By.xpath("//li[contains(@id,'srp-river-results-listing')]");
	
	private List<ItemListedComponent> itemsListed;
	
	public SearchPage(WebDriver driver) {
		super(driver);
		
		header = new HeaderComponent(driver);
		footer = new FooterComponent(driver);
		leftBar = new LeftBarComponent(driver);
		
		locateItems();
	}
	
	private void locateItems() {
		itemsListed = new ArrayList<ItemListedComponent>();
		
		for(int i=0; i<driver.findElements(itemsListedLocator).size(); i++) {
			ItemListedComponent item = new ItemListedComponent(driver);
			item.setItem(driver.findElements(itemsListedLocator).get(i));
			itemsListed.add(item);
		}

	}
	
	public ItemPage clickImageInItem(int indexOfElement) {
		getItem(indexOfElement).clickImage();
		
		return new ItemPage(driver);
	}
	
	public ItemPage clickTitleLinkInItem(int indexOfElement) {
		getItem(indexOfElement).clickTitleLink();
		
		return new ItemPage(driver);
	}

	public ItemListedComponent getItem(int indexOfElement) {
		return itemsListed.get(indexOfElement);
	}
	
	public HeaderComponent getHeader() {
		return header;
	}
	
	public FooterComponent getFooter() {
		return footer;
	}
	
	public LeftBarComponent getLeftBarComponent() {
		return leftBar;
	}

}
