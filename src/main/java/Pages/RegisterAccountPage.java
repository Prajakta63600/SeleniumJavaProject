package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {

	WebDriver driver;

	public RegisterAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement confirmPassword;

	@FindBy(xpath = "//input[@name='newsletter']")
	private WebElement subscribe;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolice;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement registerAccountTitle;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Register']")
	private WebElement registerLink;

	@FindBy(xpath = "//ul[@class='breadcrumb']//a[normalize-space()='Register']")
	private WebElement registerBreadCrumb;

	@FindBy(xpath = "//a[normalize-space()='login page']")
	private WebElement loginPageLink;

	@FindBy(xpath = "//input[@id ='input-firstname']/following-sibling::div")
	private WebElement fNWarningMsg;

	@FindBy(xpath = "//input[@id ='input-lastname']/following-sibling::div")
	private WebElement lNWarningMsg;

	@FindBy(xpath = "//input[@id ='input-email']/following-sibling::div")
	private WebElement emailWarningMsg;

	@FindBy(xpath = "//input[@id ='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningMsg;

	@FindBy(xpath = "//input[@id ='input-password']/following-sibling::div")
	private WebElement passwordWarningMsg;

	@FindBy(xpath = "//div[@class='text-danger']")
	private WebElement misMatchConfirmWarningMsg;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPoliceWarningMsg;

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountdropdownMenu;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	private WebElement loginOption;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement existingEmailWarningMsg;

	@FindBy(xpath = "//div[@class='text-danger']")
	private WebElement invalidEmail;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement invalidTelephone;

	@FindBy(xpath = "//input[@placeholder = 'First Name']")
	private WebElement placeholderFN;

	@FindBy(xpath = "//input[@placeholder = 'Last Name']")
	private WebElement placeholderLN;

	@FindBy(xpath = "//input[@placeholder = 'E-Mail']")
	private WebElement placeholderEmail;

	@FindBy(xpath = "//input[@placeholder = 'Telephone']")
	private WebElement placeholderTelephone;

	@FindBy(xpath = "//input[@placeholder = 'Password']")
	private WebElement placeholderPassword;

	@FindBy(xpath = "//input[@placeholder = 'Password Confirm']")
	private WebElement placeholderConfirmPassword;

	@FindBy(css = "label[for='input-firstname']")
	private WebElement labelFirstName;

	@FindBy(css = "label[for='input-lastname']")
	private WebElement labelLastName;

	@FindBy(css = "label[for='input-email']")
	private WebElement labelEmail;

	@FindBy(css = "label[for='input-telephone']")
	private WebElement labelTelephone;

	@FindBy(css = "label[for='input-password']")
	private WebElement labelPassword;

	@FindBy(css = "label[for='input-confirm']")
	private WebElement labelConfirmPassword;

	@FindBy(css = "a[class='agree'] b")
	private WebElement labelPrivacyPolice;
	
	@FindBy(linkText = "login page")
	private WebElement loginpageLink;
	
	@FindBy(xpath="//b[normalize-space()='Privacy Policy']")
	private WebElement privacyPoliceLink;
	
	@FindBy(xpath="//div[@class='modal-body']/p")
	private WebElement textOnPrivacyPolicePopup;
	
	@FindBy(xpath="//div[@class='modal-header']/button")
	private WebElement crossIconOnPrivacyPolivePopup;
	
	@FindBy(xpath ="//i[@class='fa fa-phone']")
	private WebElement telephoneIcon;
	
	@FindBy(xpath="//span[normalize-space()='Wish List (0)']")
	private WebElement wishList;
	
	@FindBy(xpath ="//span[normalize-space()='Shopping Cart']")
	private WebElement shoppingCart;
	
	@FindBy(xpath="//a[@title='Checkout']")
	private WebElement checkout;
	
	@FindBy(xpath="//div[@id='logo']/h1/a")
	private WebElement logo;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Login']")
	private WebElement loginLink;
	
	@FindBy(xpath="//a[@class ='list-group-item'][normalize-space()='Forgotten Password']")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[@class='list-group-item'][text()='My Account']")
	private WebElement myAccountLink;
	
	@FindBy(xpath="//a[@class='list-group-item'][text()='Address Book']")
	private WebElement addressBookLink;
	
	@FindBy(xpath="//a[normalize-space()='Wish List'][@class='list-group-item']")
	private WebElement wishListLink;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Order History']")
	private WebElement orderHistoryLink;
	
	@FindBy(xpath="//a[normalize-space()='Downloads']")
	private WebElement downloadsLink;
	
	@FindBy(xpath="//a[normalize-space()='Recurring payments']")
	private WebElement recuringPaymentLink;
	
	@FindBy(xpath="//a[normalize-space()='Reward Points']")
	private WebElement rewardPointsLink;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Returns']")
	private WebElement returnsLink;
	
	@FindBy(xpath="//a[normalize-space()='Transactions']")
	private WebElement transactionsLink;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Newsletter']")
	private WebElement newsletterLink;
	
	@FindBy(xpath="//a[text()='About Us']")
	private WebElement aboutUsFooterLink;
	
	@FindBy(xpath="//a[text()='Delivery Information']")
	private WebElement deliveryInformationFooterLink;
	
	@FindBy(xpath="//a[contains(text(), 'Privacy Policy')]")
	private WebElement privacyPoliceFooterLink;
	
	@FindBy(xpath="//a[normalize-space()='Terms & Conditions']")
	private WebElement termsAndConditionsFooterLink;
	
	@FindBy(xpath="//a[normalize-space()='Contact Us']")
	private WebElement contactUsFooterLink;
	
	@FindBy(xpath="//ul[@class='list-unstyled']//a[contains(text(), 'Returns')]")
	private WebElement returnsFooterLink;
	
	@FindBy(xpath="//a[normalize-space()='Site Map']")
	private WebElement siteMapFooterLink;
	
	@FindBy(xpath="//a[normalize-space()='Brands']")
	private WebElement brandsFooterLink;
	
	@FindBy(xpath="//a[normalize-space()='Gift Certificates']")
	private WebElement giftCertificateFooterLink;
	
	@FindBy(xpath="//a[normalize-space()='Affiliate']")
	private WebElement affiliateFooterLink;
	
	@FindBy(xpath="//a[normalize-space()='Specials']")
	private WebElement specialsFooterLink;
	
	@FindBy(xpath="//ul[@class='list-unstyled']//a[normalize-space()='My Account']")
	private WebElement myAccountFooterLink;
	
	@FindBy(xpath="//ul[@class='list-unstyled']//a[normalize-space()='Order History']")
	private WebElement orderHistoryFooterLink;
	
	@FindBy(xpath="//ul[@class='list-unstyled']//a[normalize-space()='Wish List']")
	private WebElement wishListFooterLink;
	
	@FindBy(xpath="//ul[@class='list-unstyled']//a[normalize-space()='Newsletter']")
	private WebElement newsletterFooterLink;
	
	@FindBy(xpath="//a[text()='OpenCart']")
	private WebElement openCartFooterLink;
	
	@FindBy(xpath ="//input[@name='confirm']/following-sibling::div")
	private WebElement confirmPasswordWarningMsg;
	
	@FindBy(xpath="//i[@class='fa fa-home']")
	private WebElement homeIconBreadCrumb;
	
	@FindBy(xpath ="//a[text()='Account']")
	private WebElement accountBreadCrumb;
	
	@FindBy(xpath="//h1[text()='Register Account']")
	private WebElement headingRegisterAccount;
	
	public String getTextHeadingRegisterAccount() {
		return headingRegisterAccount.getText();
	}
	
	public boolean isDisplayedAccountBreadCrumb() {
		return accountBreadCrumb.isDisplayed();
	}
	
	public boolean isDisaplyedHomeBreadCrumbIcon() {
		return homeIconBreadCrumb.isDisplayed();
	}
	
	public String getTextConfirmPasswordWarningMsg() {
		return confirmPasswordWarningMsg.getText();
	}
	
	public void clickOpenCartFooterLink() {
		openCartFooterLink.click();
	}
	
	public LoginPage clickNewsletterFooterLink() {
		newsletterFooterLink.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickWishListFooterLink() {
		wishListFooterLink.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickOrderHistoryFooterLink() {
		orderHistoryFooterLink.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickMyAccountFooterLink() {
		myAccountFooterLink.click();
		return new LoginPage(driver);
	}
	
	public SpecialOffersPage clickSpecialFooterLink() {
		specialsFooterLink.click();
		return new SpecialOffersPage(driver);
	}
	
	public AffiliateLoginPage clickAffiliateFooterLink() {
		affiliateFooterLink.click();
		return new AffiliateLoginPage(driver);
	}
	
	public GiftCertificatePage clickGiftCertificateFooterLink() {
		giftCertificateFooterLink.click();
		return new GiftCertificatePage(driver);
	}
	
	public BrandPage clickBrandsFooterLink() {
		brandsFooterLink.click();
		return new BrandPage(driver);
	}
	
	public SiteMapPage clickSiteMapFooterLink() {
		siteMapFooterLink.click();
		return new SiteMapPage(driver);
	}
	
	public ProductReturnsPage clickReturnsFooterLink() {
		returnsFooterLink.click();
		return new ProductReturnsPage(driver);
	}
	
	public ContactUsPage clickContactUsFooterLink() {
		contactUsFooterLink.click();
		return new ContactUsPage(driver);
	}
	
	public TermsAndConditionsPage clickTermsAndConditionsFooterLink() {
		termsAndConditionsFooterLink.click();
		return new TermsAndConditionsPage(driver);
	}
	
	public PrivacyPolicePage clickPrivacyPloiceFooterLink() {
		privacyPoliceFooterLink.click();
		return new PrivacyPolicePage(driver);
	}
	
	public DeliveryInformationPage clickDeliveryInformationFooterLink() {
		deliveryInformationFooterLink.click();
		return new DeliveryInformationPage(driver);
	}
	
	public AboutUsPage clickAboutUsFooterLink() {
		aboutUsFooterLink.click();
		return new AboutUsPage(driver);
	}

	public void enterFirstName(String firstNameText) {
		firstName.sendKeys(firstNameText);
	}

	public void enterLastName(String lastNameText) {
		lastName.sendKeys(lastNameText);
	}

	public void enterEmail(String emailAddress) {
		email.sendKeys(emailAddress);
	}

	public void enterTelephone(String telephoneText) {
		telephone.sendKeys(telephoneText);
	}

	public void enterPassword(String passwordText) {
		password.sendKeys(passwordText);
	}

	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPassword.sendKeys(confirmPasswordText);
	}

	public void subscribeRadioButton() {
		subscribe.click();
	}

	public void clickPrivecyPolice() {
		privacyPolice.click();
	}

	public AccountSuccessPage clickContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public String registerAccountTitleText() {
		return registerAccountTitle.getText();
	}

	public void clickRegisterLink() {
		registerLink.click();
	}

	public boolean RegisterLinkDisplayed() {
		return registerLink.isDisplayed();

	}

	public boolean displayedBreadCrumbOnRegisterAccountPage() {
		return registerBreadCrumb.isDisplayed();
	}

	public String RegisterOptionFromDropdownGetText() {
		return registerBreadCrumb.getText();
	}

	public boolean loginPageLinkDisplayed() {
		return loginPageLink.isDisplayed();
	}

	public String firstNameWarningMsgGetText() {
		return fNWarningMsg.getText();
	}

	public String lastNameWarningMsgGetText() {
		return lNWarningMsg.getText();
	}

	public String emailWarningMsgGetText() {
		return emailWarningMsg.getText();
	}

	public String telephoneWarningMsgGetText() {
		return telephoneWarningMsg.getText();
	}

	public String passwordWarningMsgGetText() {
		return passwordWarningMsg.getText();
	}

	public String privacyPoliceWarningMsgGetText() {
		return privacyPoliceWarningMsg.getText();
	}

	public void clickMyAccount() {
		myAccountdropdownMenu.click();
	}

	public LoginPage clickLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public boolean isDisplayedLoginOption() {
		return loginOption.isDisplayed();
	}

	public String misMatchConfirmWarningMsgGetText() {
		return misMatchConfirmWarningMsg.getText();
	}

	public String existingEmailWarningMsgGetText() {
		return existingEmailWarningMsg.getText();
	}

	public String invalidEmailWarningMessage() {
		return email.getDomProperty("validationMessage");
	}

	public void clearEmailField() {
		email.clear();
	}

	public String invalidEmailWarningMsgGetText() {
		return invalidEmail.getText();
	}

	public String invalidTelephoneNumberWarningMsg() {
		return invalidTelephone.getText();
	}

	public boolean placeholderFNIsDisplayed() {
		return placeholderFN.isDisplayed();
	}

	public boolean placeholderLNIsDisplayed() {
		return placeholderLN.isDisplayed();
	}

	public boolean placeholderEmailIsDisplayed() {
		return placeholderEmail.isDisplayed();
	}

	public boolean placeholderTelephoneIsDisplayed() {
		return placeholderTelephone.isDisplayed();
	}

	public boolean placeholderPasswordIsDisplayed() {
		return placeholderPassword.isDisplayed();
	}

	public boolean placeholderConfirmPasswordIsDisplayed() {
		return placeholderConfirmPassword.isDisplayed();
	}

	public String fisrtNameLabelContent(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String fNContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
				labelFirstName);
		// System.out.println(fNContent);
		return fNContent;
	}

	public String firstNameLabelColor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String fNColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", labelFirstName);
		// System.out.println(fNColor);
		return fNColor;
	}

	public String lastNameLabelContent(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String lNContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", labelLastName);
		return lNContent;
	}

	public String lastNameLabelColor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String lNColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", labelLastName);
		return lNColor;
	}

	public String emailLabelContent(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String emailContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", labelEmail);
		return emailContent;
	}

	public String emailLabelColor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String emailColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", labelEmail);
		return emailColor;
	}

	public String telephoneLabelContent(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String telephoneContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
				labelTelephone);
		return telephoneContent;
	}

	public String telephoneLabelColor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String telephoneColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", labelTelephone);
		return telephoneColor;
	}

	public String passwordLabelContent(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String passwordContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", labelPassword);
		return passwordContent;
	}

	public String passwordLabelColor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String passwordColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", labelPassword);
		return passwordColor;
	}

	public String confirmPasswordLabelContent(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String confirmPwdContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
				labelConfirmPassword);
		return confirmPwdContent;
	}

	public String confirmPasswordLabelColor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String confirmPwdColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');",
				labelConfirmPassword);
		return confirmPwdColor;
	}

	public String privacyPolicyLabelContent(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String privacyPoliceContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
				labelPrivacyPolice);
		return privacyPoliceContent;
	}

	public String privacyPolicyLabelColor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String privacyPoliceColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');",
				labelPrivacyPolice);
		return privacyPoliceColor;
	}

	public String getFirstNameFieldHeight() {
		return firstName.getCssValue("height");
	}

	public String getFirstNameFieldWidth() {
		return firstName.getCssValue("width");
	}

	public void clearFirstNameField() {
		firstName.clear();
	}

	public boolean isDisplayedFNWarningMsg() {
		return fNWarningMsg.isDisplayed();
	}

	public String getLastNameLabelHeight() {
		return lastName.getCssValue("height");
	}

	public String getLastNameLabelWidth() {
		return lastName.getCssValue("width");
	}

	public boolean isDisplayedLNWarningMsg() {
		return lNWarningMsg.isDisplayed();
	}

	public void clearLastNameField() {
		lastName.clear();
	}

	public String getEmailLabelHeight() {
		return email.getCssValue("height");
	}

	public String getEmailLabelWidth() {
		return email.getCssValue("width");
	}

	public boolean isDisplayedEmailWarningMsg() {
		return emailWarningMsg.isDisplayed();
	}

	public String getTelephoneLabelHeight() {
		return telephone.getCssValue("height");
	}

	public String getTelephoneLabelWidth() {
		return telephone.getCssValue("width");
	}

	public void clearTelephoneField() {
		telephone.clear();
	}

	public boolean isDisplayedTelephoneWarningMsg() {
		return telephoneWarningMsg.isDisplayed();
	}

	public String getPasswordLabelHieght() {
		return password.getCssValue("height");
	}

	public String getPasswordLabelWidth() {
		return password.getCssValue("width");
	}

	public void clearPasswordField() {
		password.clear();
	}

	public boolean isDisplayedPasswordWarningMsg() {
		return passwordWarningMsg.isDisplayed();
	}
	
	public String getConfirmPasswordLabelHeight() {
		return confirmPassword.getCssValue("height");
	}
	
	public String getConfirmPasswordLabelWidth() {
		return confirmPassword.getCssValue("width");
	}
	
	public boolean isSelectedPrivacyPoliceCheckbox() {
		return privacyPolice.isSelected();
	}
	
	public String getPasswordDomAttribute() {
		return password.getDomAttribute("type");
	}
	
	public String getConfirmPasswordDomAttribute() {
		return confirmPassword.getDomAttribute("type");
	}
	
	public LoginPage clickOnLoginPageLink() {
		loginpageLink.click();
		return new LoginPage(driver);
	}
	
	public void clickOnPrivacyPoliceLink() {
		privacyPoliceLink.click();
	}

	public boolean isDisplayedPrivacyPoliceText() {
		return textOnPrivacyPolicePopup.isDisplayed();
	}
	
	public void clickcrossIconOnPrivacyPolivePopup() {
		crossIconOnPrivacyPolivePopup.click();
	}
	
	public ContactUsPage clickTelephoneIcon() {
		telephoneIcon.click();
		return new ContactUsPage(driver);
	}
	
	public LoginPage clickOnWishList() {
		wishList.click();
		return new LoginPage(driver);
	}
	
	public ShoppingCartPage clickShoppingCart() {
		shoppingCart.click();
		return new ShoppingCartPage(driver);
	}
	
	public ShoppingCartPage  clickCheckout() {
		checkout.click();
		return new ShoppingCartPage(driver);
	}
	
	public void clickLogo() {
		logo.click();
	}
	
	public LoginPage clickLoginLink() {
		loginLink.click();
		return new LoginPage(driver);
	}
	
	public ForgotPasswordPage clickForgotPassword() {
		forgotPasswordLink.click();
		return new ForgotPasswordPage(driver);
	}
	
	public LoginPage clickMyAccountLink() {
		myAccountLink.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickAddressBookLink() {
		addressBookLink.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickWishListLink() {
		wishListLink.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickOrderHistoryLink() {
		orderHistoryLink.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickDownloadsLink() {
		downloadsLink.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickRecuringPaymentLink() {
		recuringPaymentLink.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickRewardPointsLink() {
		rewardPointsLink.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickReturnsLink() {
		returnsLink.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickTransactionsLink() {
		transactionsLink.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickNewsletterLink() {
		newsletterLink.click();
		return new LoginPage(driver);
	}

}
