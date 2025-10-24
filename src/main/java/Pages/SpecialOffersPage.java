package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecialOffersPage {
	
	WebDriver driver;
	
	public SpecialOffersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Special Offers']")
	private WebElement specialOffersBreadCrumb;
	
	public boolean isDisplayedSpecialOffersBreadCrumb() {
		return specialOffersBreadCrumb.isDisplayed();
	}

}
