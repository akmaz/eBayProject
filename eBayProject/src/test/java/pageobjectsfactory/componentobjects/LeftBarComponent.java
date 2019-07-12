package pageobjectsfactory.componentobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjectsfactory.pageobjects.BasePage;

public class LeftBarComponent extends BasePage {
	
	private By shapeLocator = By.xpath("//li[@name='Shape']//a");
	private By colorLocator = By.xpath("//li[@name='Color']//a");
	private By roomLocator = By.xpath("//li[@name='Room']//a");
	private By typeLocator = By.xpath("//li[@name='Type']//a");
	private By materialLocator = By.xpath("//li[@name='Material']//a");
	private By styleLocator = By.xpath("//li[@name='Style']//a");
	
	private By seeAllButtonColorLocator = By.xpath("//div[@id='w3-w2']/button");
	
	private List<WebElement> shapeOptions;
	
	public LeftBarComponent(WebDriver driver) {
		super(driver);
	}
	
	private void updateShapeOptionsList() {
		shapeOptions = driver.findElements(shapeLocator);
	}
	
	public void selectShape(int index) {
		updateShapeOptionsList();
		
		if(getShapeOption(index) != null) {
			getShapeOption(index).click();
		}
	}
	
	public void selectShape(String value) {
		updateShapeOptionsList();
		
		if(getShapeOption(value) != null) {
			getShapeOption(value).click();
		}
		
	}
	
	private WebElement getShapeOption(String name) {
		WebElement element = null;
		
		for(int i=0; i< shapeOptions.size(); i++) {
			element = shapeOptions.get(i).findElement(By.xpath("//input"));
			if(element.getAttribute("aria-label").equals(name)) {
				break;
			}
		}
		
		return element;
	}
	
	private WebElement getShapeOption(int index) {
		WebElement element = null;
		
		if(index < shapeOptions.size())
			element = shapeOptions.get(index);
		
		return element;
	}

}
