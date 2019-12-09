package pageobjectsfactory.componentobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
	private List<WebElement> colorOptions;
	
	public LeftBarComponent(WebDriver driver) {
		super(driver);
	}
	
	private void updateShapeOptionsList() {
		shapeOptions = driver.findElements(shapeLocator);
	}
	
	private void updateColorOptionsList() {
		colorOptions = driver.findElements(colorLocator);
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
		int i;
		
		for(i=0; i< shapeOptions.size(); i++) {

			element = shapeOptions.get(i).findElement(By.xpath("div//span"));
			if(read(element).equals(name)) {
				break;
			}
		}
		
		return shapeOptions.get(i);
	}
	
	private WebElement getShapeOption(int index) {
		WebElement element = null;
		
		if(index < shapeOptions.size())
			element = shapeOptions.get(index);
		
		return element;
	}

}
