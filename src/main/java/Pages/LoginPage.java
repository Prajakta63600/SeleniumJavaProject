package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Continue")
	private WebElement continueButton;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Register']")
	private WebElement registerLink;

	@FindBy(xpath = "//ul[@class='breadcrumb']//a[normalize-space()='Login']")
	private WebElement loginBreadCrumb;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-password")
	private WebElement pwdField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	private WebElement logoutLink;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement noMatchWarningMessage;
	
	@FindBy(xpath="//div[@class='form-group']/a")
	private WebElement forgotPassword;
	
	@FindBy(xpath="//input[@placeholder='E-Mail Address']")
	private WebElement emailPlaceholder;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement passwordPlaceholder;
	
	@FindBy(xpath="//a[@class='list-group-item'][contains(text(), 'My Account')]")
	private WebElement myAccountRightOption;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement attemptExceedWarningMsg;
	
	public String getTextAttemptExceedWarningMsg() {
		return attemptExceedWarningMsg.getText();
	}
	
	public AccountPage clickMyAccountRightOption() {
		myAccountRightOption.click();
		return new AccountPage(driver);
	}
	
	public boolean getPwdPlaceholder() {
		return passwordPlaceholder.isDisplayed();
	}
	
	public boolean getEmailPlaceholder() {
		return emailPlaceholder.isDisplayed();
	}
	
	public boolean isDisplayedForgotPassword() {
		return forgotPassword.isDisplayed();
	}
	
	public ForgotPasswordPage clickForgotPassword() {
		forgotPassword.click();
		return new ForgotPasswordPage(driver);
	}
	
	public String getTextNoMatcharningMsg() {
		return noMatchWarningMessage.getText();
	}
	
	public String getTextLogoutLink() {
		return logoutLink.getText();
	}

	public AccountPage clickLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}

	public void enterPwdField(String pwd) {
		pwdField.sendKeys(pwd);
	}
	
	public String getPasswordDOmAttributeType() {
		return pwdField.getDomAttribute("type");
	}

	public void enterEmailField(String email) {
		emailField.sendKeys(email);
	}

	public void clickContinueButton() {
		continueButton.click();
	}

	public boolean RegisterLinkDisplayed() {
		return registerLink.isDisplayed();
	}

	public void clickRegisterLink() {
		registerLink.click();
	}

	public boolean isDisplayedLoginBreadCrumb() {
		return loginBreadCrumb.isDisplayed();
	}

}
