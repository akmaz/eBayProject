package pageobjectsfactory.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class represents a page object - Cart Feedback page
 * 
 * @author aleks
 *
 */

public class CartFeedbackPage extends BasePage {
	
	private static final String URL_NOT_COMPLETE = "https://connect.ebay.com/srv/survey/";
	private static final String PAGE_TITLE = "Cart feedback";
	
	
	private By eBayIconLocator = By.xpath("//a[@id='gh-la']");
	
	private By radioChoicesLocator = By.xpath("//*[@id='q0']//fieldset[1]/div[@class='field']");
			//By.xpath("//form[@id='theSurvey']//fieldset[@class='sr-fieldset branch-margin']//div[@class='field']");
	private List<WebElement> radioChoices;
	private By tellUsMoreLocator = By.xpath("//textarea[@id='qid_3']");
	private By issueChoicesLocator = By.xpath("//div[@class='choices radios'][2]//div[@class='field']//input[@type='radio']");
	private List<WebElement> radioIssueChoices;
	private By inputOtherLocator = By.xpath("//input[@id='qid_2']");
	private By sendButtonLocator = By.xpath("//button[@id='submitFdbk']");
	
	
	public CartFeedbackPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void assertTitle() {
		assertEquals(PAGE_TITLE, getTitle());
	}
	
	/*
	 * different types of surveys might have different full url,
	 * therefore we will only validate if the beginning of the url is correct
	 */
	
	public void assertUrl() {
		assertTrue(getUrl().contains(URL_NOT_COMPLETE));

	}
	
	public MainPage clickeBayIcon() {
		click(driver.findElement(eBayIconLocator));
		
		return new MainPage(driver);
	}
	
	private void locateChoices() {
		radioChoices = driver.findElements(radioChoicesLocator);
		System.out.println(radioChoices.size());
	}
	
	/*
	 * available values = love, issue, suggestion
	 */
	public void setChoice(String value) {
		locateChoices();
		
		if(radioChoices.size()>0) {
			for(int i=0; i<radioChoices.size(); i++) {
				WebElement element = radioChoices.get(i).findElement(By.xpath("//input[@type='radio']"));
				if(element.getAttribute("value").equals(value)) {
					element.click();
					break;
				}
			}
		}
	}
	
	public void writeIntoTellUsMoreBox(String text) {
		if(text.length() <= 1000)
			write(driver.findElement(tellUsMoreLocator), text);
	}
	
	/*
	 * available values are: loading_cart, slow_cart, other
	 */
	public void setIssueChoice(String value) {
		radioIssueChoices = driver.findElements(issueChoicesLocator);
		
		if(radioIssueChoices.size()>0) {
			for(int i=0; i<radioIssueChoices.size(); i++) {
				if(radioIssueChoices.get(i).getAttribute("value").equals(value)) {
					radioIssueChoices.get(i).click();
					break;
				}
			}
		}
	}
	
	public void setIssueChoiceWriteOther(String value, String otherText) {
		if(radioChoices.size()>0 && otherText.length() <= 50) {
			for(int i=0; i<radioChoices.size(); i++) {
				if(radioIssueChoices.get(i).getAttribute("value").equals("other")) {
					radioChoices.get(i).click();
					write(driver.findElement(inputOtherLocator), otherText);
					break;
				}
			}
		}
	}
	
	public void clickSendButton() {
		click(driver.findElement(sendButtonLocator));
	}
	
	
	
	
}
