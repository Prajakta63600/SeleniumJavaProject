package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Forgotten Password']")
	private WebElement forgotPasswordBreadCrumb;
	
	@FindBy(xpath="//h1[normalize-space()='Forgot Your Password?']")
	private WebElement TitleForgotPassword;
	
	public String getTextTitleForgotPassword() {
		return TitleForgotPassword.getText();
	}
	
	public boolean isDisplayedForgotPasswordBreadCrumb() {
		return forgotPasswordBreadCrumb.isDisplayed();
	}
}
