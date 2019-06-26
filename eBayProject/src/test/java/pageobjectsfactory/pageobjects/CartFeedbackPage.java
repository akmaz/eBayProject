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
	
	private By eBayIconLocator = By.xpath("//a[@id='gh-la']");
	
	private By radioChoicesLocator = By.xpath("//div[@class='choices radios']//div[@class='field']//input[@type='radio']");
	private List<WebElement> radioChoices;
	private By tellUsMoreLocator = By.xpath("//textarea[@id='qid_3']");
	private By issueChoicesLocator = By.xpath("//div[@class='choices radios'][2]//div[@class='field']//input[@type='radio']");
	private List<WebElement> radioIssueChoices;
	private By inputOtherLocator = By.xpath("//input[@id='qid_2']");
	private By sendButtonLocator = By.xpath("//button[@id='submitFdbk']");
	
	private int k = -1;
	
	public CartFeedbackPage(WebDriver driver) {
		super(driver);
		
		locateChoices();
	}
	
	public MainPage clickeBayIcon() {
		click(driver.findElement(eBayIconLocator));
		
		return new MainPage(driver);
	}
	
	private void locateChoices() {
		radioChoices = driver.findElements(radioChoicesLocator);
	}
	
	/*
	 * available values = love, issue, suggestion
	 */
	public void setChoice(String value) {
		if(radioChoices.size()>0) {
			for(int i=0; i<radioChoices.size(); i++) {
				if(radioChoices.get(i).getAttribute("value").equals(value)) {
					radioChoices.get(i).click();
					k=i;
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
