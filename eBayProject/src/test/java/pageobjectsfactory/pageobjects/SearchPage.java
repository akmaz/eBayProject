package pageobjectsfactory.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageobjectsfactory.componentobjects.FooterComponent;
import pageobjectsfactory.componentobjects.HeaderComponent;
import pageobjectsfactory.componentobjects.ItemListedComponent;

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
	
	private By itemsListedBy = By.xpath("//li[contains(@id,'srp-river-results-listing')]");
	
	private List<ItemListedComponent> itemsListed;
	
	public SearchPage(WebDriver driver) {
		super(driver);
		
		header = new HeaderComponent(driver);
		footer = new FooterComponent(driver);
		
		locateItems();
	}
	
	private void locateItems() {
		itemsListed = new ArrayList<ItemListedComponent>();
		
		for(int i=0; i<driver.findElements(itemsListedBy).size(); i++) {
			ItemListedComponent item = new ItemListedComponent(driver);
			item.setItem(driver.findElements(itemsListedBy).get(i));
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

}
