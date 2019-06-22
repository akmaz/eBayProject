package tests;

import org.testng.annotations.Test;

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
	public void openAndAssertCartPage() {
		
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
	public void unloggedViewShoppingCard() {
		
		MainPage mainPage = new MainPage(driver);
		mainPage.openMainPage();
		
		CartPage cartPage = mainPage.getHeader().clickCartIcon();
		cartPage.checkIfCartEmpty();
		
	}
	
	/**
	 * TC003
	 * 
	 * Method navigates to the Cart page from the Main page, and clicks on the 'Start shopping' link,
	 * and verifies if it brings user to the Main page again
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
	 * Method searches for any item and adds one item to the cart,
	 * then navigates to the cart and verifies if it displays the correct price
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
		itemPage.selectItemTypeByIndex(4);
		System.out.println(itemPage.getPrice());
		itemPage.clickAddToCardButton();
		
		
		
	}


}
