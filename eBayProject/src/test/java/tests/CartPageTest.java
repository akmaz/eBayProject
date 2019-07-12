package tests;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjectsfactory.pageobjects.CartFeedbackPage;
import pageobjectsfactory.pageobjects.CartPage;
import pageobjectsfactory.pageobjects.ItemPage;
import pageobjectsfactory.pageobjects.MainPage;
import pageobjectsfactory.pageobjects.SearchPage;

/**
 * Class covers test cases for the Cart Page of the eBay page
 * 
 * @author aleks
 *
 */

public class CartPageTest extends BaseTest{
	
	private final String searchedItem = "blanket";
	
	/**
	 * TC001
	 * 
	 * Method navigates to the Cart page from the Main page, and asserts if the title and URL are correct
	 * 
	 * @param no args
	 * @return void
	 */
	
	@Test
	public void unloggedViewAndAssertCartPage() {
		
		MainPage mainPage = new MainPage(driver);
		mainPage.openMainPage();
		
		CartPage cartPage = mainPage.getHeader().clickCartIcon();
		cartPage.assertTitle();
		cartPage.assertUrl();
		
	}
	
	/**
	 * TC002
	 * 
	 * Method navigates to the Cart page from the Main page, and verifies if the card is empty
	 * 
	 * @param no args
	 * @return void
	 */
	
	@Test
	public void unloggedViewCartPageCheckIfEmpty() {
		
		MainPage mainPage = new MainPage(driver);
		mainPage.openMainPage();
		
		CartPage cartPage = mainPage.getHeader().clickCartIcon();
		cartPage.checkIfCartEmpty();
		
	}
	
	/**
	 * TC003
	 * 
	 * Method navigates to the Cart page from the Main page, and clicks on the 'Start shopping' link,
	 * and verifies if it brings user to the correct page
	 * 
	 * @param no args
	 * @return void
	 */
	
	@Test
	public void unloggedEmptyCartStartShopping() {
		
		MainPage mainPage = new MainPage(driver);
		mainPage.openMainPage();
		
		CartPage cartPage = mainPage.getHeader().clickCartIcon();
		mainPage = cartPage.clickStartShoppingButton();
		mainPage.assertTitle();
		mainPage.assertUrl();
		
	}
	
	/**
	 * TC004
	 * 
	 * Opens Cart page on its own, clicks on the 'Send Us Your Comments' link,
	 * verifies if it brings user to the correct page, and fills in a feedback form
	 * 
	 * @param no args
	 * @return void
	 */
	
	@Test
	public void unloggedEmptyCartSendUsYourComments() {
		
		CartPage cartPage = new CartPage(driver);
		cartPage.openCardPage();
		String w1 = driver.getWindowHandle();
		CartFeedbackPage cartFeedbackPage = cartPage.clickSendUsYourCommentsLink();
		
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows) {
			driver.switchTo().window(window);
			if(window.equals(w1))
				driver.close();
		}
		
		cartFeedbackPage.assertTitle();
		cartFeedbackPage.assertUrl();
		cartFeedbackPage.setChoice("love");
		cartFeedbackPage.writeIntoTellUsMoreBox("Sample text... Hello!");
		cartFeedbackPage.clickSendButton();
		
	}
	
	/**
	 * TC005
	 * 
	 * Method searches for an item 'blanket' and adds the first item in the list to the cart,
	 * then navigates to the cart and verifies if it displays the correct price as in the offer
	 * and click to remove the item
	 * 
	 * @param no args
	 * @return void
	 */
	
	@Test
	public void unloggedAddItemToEmpyCart() {
		
		MainPage mainPage = new MainPage(driver);
		mainPage.openMainPage();
		
		mainPage.getHeader().typeInSearch(searchedItem);
		SearchPage searchPage = mainPage.getHeader().clickSearchButton();

		ItemPage itemPage = searchPage.clickTitleLinkInItem(0);
		itemPage.selectFeatureByIndex(1, 1);
		itemPage.selectFeatureByIndex(2, 2);
		
		
		itemPage.clickAddToCardButton();
		double price = itemPage.getFinalPrice();
		
		CartPage cartPage = itemPage.clickGoToCart();
		Assert.assertEquals(cartPage.getItem(0).getPrice(), price);

		cartPage.getItem(0).removeItem();
		cartPage.checkItemRemoved();
	}
	

}
