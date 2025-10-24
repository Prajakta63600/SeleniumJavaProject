package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterPage {
	WebDriver driver;
	
	public NewsletterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[normalize-space()='Newsletter Subscription']")
	private WebElement newsletterSubscription;
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Newsletter']")
	private WebElement newsletterBreadCrumb;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement subscribeRadioButtonYes;
	
	@FindBy(xpath="//input[@value='0']")
	private WebElement subscribeRadioButtonNo;
	
	public boolean newsletterSubscriptionHeader() {
		return newsletterSubscription.isDisplayed();
	}
	
	public String newsletterSubscriptionHeaderGetText() {
		return newsletterSubscription.getText();
	}

	public boolean newsletterBreadCrumbDisplayed() {
		return newsletterBreadCrumb.isDisplayed();
	}
	
	public boolean subscribeRadioButtonYesSelected()
	{
		return subscribeRadioButtonYes.isSelected();
	}
	
	public boolean subscribeRadioButtonNoSelected() {
		return subscribeRadioButtonNo.isSelected();
	}
}
