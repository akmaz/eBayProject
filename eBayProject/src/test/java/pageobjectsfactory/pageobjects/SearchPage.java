package pageobjectsfactory.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageobjectsfactory.componentobjects.FooterObject;
import pageobjectsfactory.componentobjects.HeaderObject;
import pageobjectsfactory.componentobjects.ItemListedObject;

public class SearchPage extends BasePage {

	private static final String PART_OF_PAGE_TITLE = " | eBay";
	
	private HeaderObject header;
	private FooterObject footer;
	
	private By itemsListedBy = By.xpath("//li[contains(@id,'srp-river-results-listing')]");
	
	private List<ItemListedObject> itemsListed;
	
	public SearchPage(WebDriver driver) {
		super(driver);
		
		header = new HeaderObject(driver);
		footer = new FooterObject(driver);
		
		locateItems();
	}
	
	private void locateItems() {
		itemsListed = new ArrayList<ItemListedObject>();
		
		for(int i=0; i<driver.findElements(itemsListedBy).size(); i++) {
			ItemListedObject item = new ItemListedObject(driver);
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

	public ItemListedObject getItem(int indexOfElement) {
		return itemsListed.get(indexOfElement);
	}
}
