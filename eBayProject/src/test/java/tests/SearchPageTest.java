package tests;

import org.testng.annotations.Test;

import pageobjectsfactory.pageobjects.MainPage;
import pageobjectsfactory.pageobjects.SearchPage;

/**
 * Class covers test cases for the Search Page of the eBay page
 * 
 * @author aleks
 *
 */

public class SearchPageTest extends BaseTest {
	
	private String searchedExpression = "rug";
	private String shapeChoice = "Round";

	/**
	 * TC001 & TC002
	 * 
	 * Method navigates to the Main page, searches for an item 'rug',
	 * and on the Search page selects a feature Shape - 'Round'
	 * 
	 * @param no args
	 * @return void
	 */
	
	@Test
	public void searchForRug() {
		MainPage mainPage = new MainPage(driver);
		
		mainPage.openMainPage();
		mainPage.getHeader().typeInSearch(searchedExpression);
		
		SearchPage searchPage = mainPage.getHeader().clickSearchButton();
		searchPage.assertTitle();
		
		searchPage.getLeftBarComponent().selectShape(shapeChoice);
	}
}
