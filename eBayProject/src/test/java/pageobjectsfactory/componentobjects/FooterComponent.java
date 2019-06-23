package pageobjectsfactory.componentobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageobjectsfactory.pageobjects.BasePage;

/**
 * Class represents a component object - Footer on subpages (such as on Cart subpage)
 * 
 * @author aleks
 *
 */

public class FooterComponent extends BasePage {
	
	@FindBy(xpath = "//li[@class='gf-li']/a[text() = 'About eBay']")
	private WebElement abouteBayLink;
	
	@FindBy(xpath = "//li[@class='gf-li']/a[text() = 'Announcements']")
	private WebElement announcementsLink;
	
	@FindBy(xpath = "//li[@class='gf-li']/a[text() = 'Community']")
	private WebElement communityLink;
	
	@FindBy(xpath = "//li[@class='gf-li']/a[text() = 'Security Center']")
	private WebElement securityCenterLink;
	
	@FindBy(xpath = "//li[@class='gf-li']/a[text() = 'Resolution Center']")
	private WebElement resolutionCenterLink;
	
	@FindBy(xpath = "//li[@class='gf-li']/a[text() = 'Seller Center']")
	private WebElement sellerCenterLink;
	
	@FindBy(xpath = "//li[@class='gf-li']/a[text() = 'Policies']")
	private WebElement policiesLink;
	
	@FindBy(xpath = "//li[@class='gf-li']/a[text() = 'Affiliates']")
	private WebElement affiliatesLink;

	@FindBy(xpath = "//li[@class='gf-li']/a[text() = 'Help & Contact']")
	private WebElement helpContactLink;
	
	@FindBy(xpath = "//li[@class='gf-li']/a[text() = 'Site Map']")
	private WebElement siteMap;
	
	@FindBy(xpath = "//td[@class='gf-legal']/a[text()='Accessibility']")
	private WebElement accessibilityLink;
	
	@FindBy(xpath = "//td[@class='gf-legal']/a[text()='User Agreement']")
	private WebElement userAgreementLink;
	
	@FindBy(xpath = "//td[@class='gf-legal']/a[text()='Privacy']")
	private WebElement privacyLink;
	
	@FindBy(xpath = "//td[@class='gf-legal']/a[text()='Cookies']")
	private WebElement cookiesLink;
	
	@FindBy(xpath = "//td[@class='gf-legal']/a[text()='AdChoice']")
	private WebElement adChoiceLink;
	
	@FindBy(xpath = "//i[@id='gf-norton']")
	private WebElement nortonSecuredIcon;
	
	@FindBy(xpath = "//button[@id='gh-bt']")
	private WebElement arrowButton;
	
	
	public FooterComponent(WebDriver driver) {
		super(driver);

	}
	
	public void clickAbouteBayLink() {
		click(abouteBayLink);
	}
	
	public void clickAnnouncementsLink() {
		click(announcementsLink);
	}
	
	public void clickCommunityLink() {
		click(communityLink);
	}
	
	public void clickSecurityCenterLink() {
		click(securityCenterLink);
	}
	
	public void clickResolutionCenterLink() {
		click(resolutionCenterLink);
	}
	
	public void clickSellerCenterLink() {
		click(sellerCenterLink);
	}
	
	public void clickPoliciesLink() {
		click(policiesLink);
	}
	
	public void clickAffiliatesLink() {
		click(affiliatesLink);
	}
	
	public void clickHelpContactLink() {
		click(helpContactLink);
	}
	
	public void clickSiteMap() {
		click(siteMap);
	}
	
	public void clickAccessibilityLink() {
		click(accessibilityLink);
	}
	
	public void clickUserAgreementLink() {
		click(userAgreementLink);
	}
	
	public void clickPivacyLink() {
		click(privacyLink);
	}
	
	public void clickCookiesLink() {
		click(cookiesLink);
	}
	
	public void clickAdChoiceLink() {
		click(adChoiceLink);
	}
	
	public void clickNortonSecuredIcon() {
		click(nortonSecuredIcon);
	}
	
	public void clickArrowButton() {
		click(arrowButton);
	}

}
