package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrivacyPolicePage {
	
	WebDriver driver;
	
	public PrivacyPolicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(), 'Privacy Policy')]")
	private WebElement privacyPoliceFooterLink;
	
	public boolean isDisplayedPrivacyPoliceFooterLink() {
		return privacyPoliceFooterLink.isDisplayed();
	}

}
