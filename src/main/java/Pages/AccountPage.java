package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {

	WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Edit your account information']")
	private WebElement editYourAccountInformationLink;

	@FindBy(linkText = "Subscribe / unsubscribe to newsletter")
	private WebElement newsletterLink;

	@FindBy(xpath = "//ul[@class='breadcrumb']//a[contains(text(), 'Account')]")
	private WebElement accountBreadCrumb;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	private WebElement logoutRightOption;

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropdown;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	private WebElement dropdownLogoutOption;

	public void clickLogoutOptionFromDropdwon() {
		dropdownLogoutOption.click();
	}

	public void clickMyAccountDropdown() {
		myAccountDropdown.click();
	}

	public String getTextLogoutRightOption() {
		return logoutRightOption.getText();
	}

	public AccountLogoutPage clickLogoutRightOption() {
		logoutRightOption.click();
		return new AccountLogoutPage(driver);
	}

	public boolean isDisplayedAccountBreadCrumb() {
		return accountBreadCrumb.isDisplayed();
	}

	public boolean EditYourAccountInformation() {
		return editYourAccountInformationLink.isDisplayed();
	}

	public EditInformationPage clickEditYourAccountInformation() {
		editYourAccountInformationLink.click();
		return new EditInformationPage(driver);
	}

	public NewsletterPage clickNewsLetterLink() {
		newsletterLink.click();
		return new NewsletterPage(driver);
	}

}
