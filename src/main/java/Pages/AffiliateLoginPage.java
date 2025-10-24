package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AffiliateLoginPage {
	
	WebDriver driver;
	
	public AffiliateLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://tutorialsninja.com/demo/index.php?route=affiliate/login'][normalize-space()='Login']")
	private WebElement LoginBreadCrumb;
	
	public boolean isDisplayedLoginBreadCrumb() {
		return LoginBreadCrumb.isDisplayed();
	}

}
