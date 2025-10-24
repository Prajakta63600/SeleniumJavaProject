package tutorialninja.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.AboutUsPage;
import Pages.AccountPage;
import Pages.AccountSuccessPage;
import Pages.AffiliateLoginPage;
import Pages.BrandPage;
import Pages.ContactUsPage;
import Pages.DeliveryInformationPage;
import Pages.EditInformationPage;
import Pages.ForgotPasswordPage;
import Pages.GiftCertificatePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewsletterPage;
import Pages.PrivacyPolicePage;
import Pages.ProductReturnsPage;
import Pages.RegisterAccountPage;
import Pages.ShoppingCartPage;
import Pages.SiteMapPage;
import Pages.SpecialOffersPage;
import Pages.TermsAndConditionsPage;
import tutorialninja.base.baseClass;
import utils.CommonUtils;

public class Register extends baseClass {
	Properties prop;
	HomePage homePage;
	RegisterAccountPage registerPage;
	AccountSuccessPage successPage;
	AccountPage accountPage;
	NewsletterPage newsletterPage;
	LoginPage loginPage;
	EditInformationPage editInfoPage;
	ContactUsPage contactPage;
	ShoppingCartPage shoppingCartPage;
	ForgotPasswordPage forgotPasswordPage;
	AboutUsPage aboutUsPage;
	DeliveryInformationPage deliveryInfoPage;
	PrivacyPolicePage privacyPolicePage;
	TermsAndConditionsPage termsAndConditionPage;
	ProductReturnsPage productReturnsPage;
	SiteMapPage siteMapPage;
	BrandPage brandPage;
	GiftCertificatePage giftCertificatePage;
	AffiliateLoginPage affiliatePage;
	SpecialOffersPage specialOfferPage;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOption();

	}

	@Test(priority = 1)
	public void registerWithEmail() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateEmail());
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("confirmPassword"));
		registerPage.clickPrivecyPolice();
		successPage = registerPage.clickContinueButton();

		Assert.assertTrue(successPage.logout());

		String actualRegisterSuccessDetails = successPage.HeaderMessage();
		Assert.assertEquals(actualRegisterSuccessDetails, "Your Account Has Been Created!");

		String actualProperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String actualProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDetailsFour = "contact us";

		String expectedProperDetails = successPage.RegisteredSuccessfulyMsg();

		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsOne));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsTwo));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsThree));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsFour));

		accountPage = successPage.clickContinueButton();

		Assert.assertTrue(accountPage.EditYourAccountInformation());

	}

	@Test(priority = 2)
	public void verifyRegisterSuccesfullPage() throws InterruptedException {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateEmail());
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("confirmPassword"));
		registerPage.clickPrivecyPolice();
		successPage = registerPage.clickContinueButton();

		Thread.sleep(5000);
		Assert.assertTrue(successPage.logout());
		Assert.assertTrue(successPage.successBreadCrumb());

		String actualProperDetails0 = "Your Account Has Been Created!";
		String actualProperDetails1 = "Congratulations! Your new account has been successfully created!";
		String actualProperDetails2 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetails3 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDetails4 = "contact us";

		String expectedProperDetails = successPage.RegisteredSuccessfulyMsg();

		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails0));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails1));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails2));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails3));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails4));

		accountPage = successPage.clickContinueButton();

		Assert.assertTrue(accountPage.EditYourAccountInformation());

	}

	@Test(priority = 3)
	public void verifyValidationMessageOnRegisterPage() throws InterruptedException {

		registerPage.clickContinueButton();
		Thread.sleep(5000);

		String FirstNameError = registerPage.firstNameWarningMsgGetText();

		Assert.assertTrue(FirstNameError.contains("First Name must be between 1 and 32 characters!"));
		Assert.assertEquals(registerPage.lastNameWarningMsgGetText(), "Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(registerPage.emailWarningMsgGetText(), "E-Mail Address does not appear to be valid!");
		Assert.assertEquals(registerPage.telephoneWarningMsgGetText(),
				"Telephone must be between 3 and 32 characters!");
		Assert.assertEquals(registerPage.passwordWarningMsgGetText(), "Password must be between 4 and 20 characters!");
		Assert.assertEquals(registerPage.privacyPoliceWarningMsgGetText(),
				"Warning: You must agree to the Privacy Policy!");

	}

	@Test(priority = 4)
	public void verifyRegisteringAccountBySubscribingNewsLetter() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateEmail());
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("confirmPassword"));
		registerPage.subscribeRadioButton();
		registerPage.clickPrivecyPolice();
		successPage = registerPage.clickContinueButton();

		Assert.assertTrue(successPage.logout());

		accountPage = successPage.clickContinueButton();
		newsletterPage = accountPage.clickNewsLetterLink();

		Assert.assertTrue(newsletterPage.newsletterSubscriptionHeader());
		Assert.assertTrue(newsletterPage.newsletterBreadCrumbDisplayed());
		Assert.assertEquals(newsletterPage.newsletterSubscriptionHeaderGetText(), "Newsletter Subscription");
		Assert.assertTrue(newsletterPage.subscribeRadioButtonYesSelected());

	}

	@Test(priority = 5)
	public void verifyRegisterWithNoSubscribtion() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateEmail());
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("confirmPassword"));
		registerPage.clickPrivecyPolice();
		successPage = registerPage.clickContinueButton();

		Assert.assertTrue(successPage.logout());

		Assert.assertTrue(successPage.successBreadCrumb());

		accountPage = successPage.clickContinueButton();
		newsletterPage = accountPage.clickNewsLetterLink();

		Assert.assertTrue(newsletterPage.newsletterBreadCrumbDisplayed());
		Assert.assertTrue(newsletterPage.subscribeRadioButtonNoSelected());

	}

	@Test(priority = 6)
	public void verifyNevigateToRegisterPage() {

		Assert.assertEquals(registerPage.registerAccountTitleText(), "Register Account");

		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();
		loginPage.clickContinueButton();

		Assert.assertEquals(registerPage.registerAccountTitleText(), "Register Account");

		homePage.clickOnMyAccount();
		homePage.selectLoginOption();

		Assert.assertTrue(loginPage.RegisterLinkDisplayed());
		loginPage.clickRegisterLink();
		Assert.assertEquals(registerPage.registerAccountTitleText(), "Register Account");

		registerPage.clickRegisterLink();

		Assert.assertTrue(registerPage.RegisterLinkDisplayed());
		Assert.assertEquals(registerPage.registerAccountTitleText(), "Register Account");

	}

	@Test(priority = 7)
	public void verifyRegisterAccountPage() {

		Assert.assertTrue(registerPage.displayedBreadCrumbOnRegisterAccountPage());
		Assert.assertEquals(registerPage.registerAccountTitleText(), "Register Account");
		Assert.assertTrue(registerPage.loginPageLinkDisplayed());

		registerPage.clickMyAccount();
		loginPage = registerPage.clickLoginOption();
		loginPage.clickContinueButton();

		Assert.assertTrue(registerPage.displayedBreadCrumbOnRegisterAccountPage());
		Assert.assertEquals(registerPage.registerAccountTitleText(), "Register Account");
		Assert.assertTrue(registerPage.loginPageLinkDisplayed());

		registerPage.clickMyAccount();
		loginPage = registerPage.clickLoginOption();
		loginPage.clickRegisterLink();

		Assert.assertTrue(registerPage.displayedBreadCrumbOnRegisterAccountPage());
		Assert.assertEquals(registerPage.registerAccountTitleText(), "Register Account");
		Assert.assertTrue(registerPage.loginPageLinkDisplayed());

	}

	@Test(priority = 8)
	public void verifyRegisterNewUserWithWrongPassword() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateEmail());
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword("tony132");
		registerPage.clickPrivecyPolice();
		registerPage.clickContinueButton();

		Assert.assertEquals(registerPage.misMatchConfirmWarningMsgGetText(),
				"Password confirmation does not match password!");

	}

	@Test(priority = 9)
	public void verifyRegisterNewUserWithExistingEmail() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(prop.getProperty("email"));
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("confirmPassword"));
		registerPage.clickPrivecyPolice();
		registerPage.clickContinueButton();

		String actualWarningMessage = registerPage.existingEmailWarningMsgGetText();
		String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
		if (actualWarningMessage.contains(expectedWarningMessage)) {
			System.out.println("Warning message is displayed");
		} else {
			System.out.println("Warning message is not displayed");
		}

	}

	@Test(priority = 10)
	public void verifyEmailFieldWithDifferentData() throws IOException, InterruptedException {

		String browserName = prop.getProperty("browserName");

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail("tony");
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("confirmPassword"));
		registerPage.clickPrivecyPolice();
		registerPage.clickContinueButton();

		if (browserName.equals("chrome") || browserName.equals("edge")) {
			Assert.assertEquals(registerPage.invalidEmailWarningMessage(),
					"Please include an '@' in the email address. 'tony' is missing an '@'.");
		} else if (browserName.equals("firefox")) {
			Assert.assertEquals(registerPage.invalidEmailWarningMessage(), "Please enter an email address.");
		}

		registerPage.clearEmailField();
		registerPage.enterEmail("tony@gmail.");
		registerPage.clickContinueButton();

		if (browserName.equals("firefox")) {
			Assert.assertEquals(registerPage.invalidEmailWarningMessage(), "Please enter an email address.");
		} else if (browserName.equals("chrome") || browserName.equals("edge")) {
			Assert.assertEquals(registerPage.invalidEmailWarningMessage(),
					"'.' is used at a wrong position in 'gmail.'.");
		}

		registerPage.clearEmailField();
		registerPage.enterEmail("tony@");
		registerPage.clickContinueButton();

		if (browserName.equals("firefox")) {
			Assert.assertEquals(registerPage.invalidEmailWarningMessage(), "Please enter an email address.");
		} else if (browserName.equals("chrome") || browserName.equals("edge")) {
			Assert.assertEquals(registerPage.invalidEmailWarningMessage(),
					"Please enter a part following '@'. 'tony@' is incomplete.");
		}

		registerPage.clearEmailField();
		registerPage.enterEmail("tony@gmail");
		registerPage.clickContinueButton();

		Assert.assertEquals(registerPage.invalidEmailWarningMsgGetText(),
				"E-Mail Address does not appear to be valid!");

	}

	@Test(priority = 11)
	public void verifyInvalidTelephoneNumber() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateEmail());
		registerPage.enterTelephone("abcdef");
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("confirmPassword"));
		registerPage.clickPrivecyPolice();
		registerPage.clickContinueButton();

		// failing the script has there is defect even after entering invalid telephone
		// numbers its allowing user to register.
		String expectedMessage = "Telephone Number dose not appear to be valid";
		Assert.assertEquals(registerPage.invalidTelephoneNumberWarningMsg(), expectedMessage);

	}

	@Test(priority = 12)
	public void verifyRegisterAccountPageUsingKeyboardKeys() throws InterruptedException {

		Actions actions = new Actions(driver);
		for (int i = 0; i < 23; i++) {
			actions.sendKeys(Keys.TAB).perform();
		}

		actions.sendKeys(prop.getProperty("firstName")).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(prop.getProperty("lastName")).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(CommonUtils.generateEmail()).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(prop.getProperty("telephone")).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(prop.getProperty("password")).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(prop.getProperty("confirmPassword")).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).build().perform();

		successPage = new AccountSuccessPage(driver);
		Assert.assertEquals(successPage.logoutGetText(), "Logout");
		Assert.assertTrue(successPage.accountCreatedTitleMsg());

	}

	@Test(priority = 13)
	public void verifyRegisterPagePlaceholder() {

		Assert.assertTrue(registerPage.placeholderFNIsDisplayed());
		Assert.assertTrue(registerPage.placeholderLNIsDisplayed());
		Assert.assertTrue(registerPage.placeholderEmailIsDisplayed());
		Assert.assertTrue(registerPage.placeholderTelephoneIsDisplayed());
		Assert.assertTrue(registerPage.placeholderPasswordIsDisplayed());
		Assert.assertTrue(registerPage.placeholderConfirmPasswordIsDisplayed());

	}

	@Test(priority = 14)
	public void verifyRegisterPageFieldName() {
		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// FirstName Astrick and color
		Assert.assertEquals(registerPage.fisrtNameLabelContent(driver), expectedContent);
		Assert.assertEquals(registerPage.firstNameLabelColor(driver), expectedColor);

		// LastName Astrick and color
		Assert.assertEquals(registerPage.lastNameLabelContent(driver), expectedContent);
		Assert.assertEquals(registerPage.lastNameLabelColor(driver), expectedColor);

		// Email astrik and color
		Assert.assertEquals(registerPage.emailLabelContent(driver), expectedContent);
		Assert.assertEquals(registerPage.emailLabelColor(driver), expectedColor);

		// Telephone astrik and color
		Assert.assertEquals(registerPage.telephoneLabelContent(driver), expectedContent);
		Assert.assertEquals(registerPage.telephoneLabelColor(driver), expectedColor);

		// Password field
		Assert.assertEquals(registerPage.passwordLabelContent(driver), expectedContent);
		Assert.assertEquals(registerPage.passwordLabelColor(driver), expectedColor);

		// Confirm Password field
		Assert.assertEquals(registerPage.confirmPasswordLabelContent(driver), expectedContent);
		Assert.assertEquals(registerPage.confirmPasswordLabelColor(driver), expectedColor);

		// Privacy Police
		Assert.assertEquals(registerPage.privacyPolicyLabelContent(driver), expectedContent);
		// failing script here because privacy police as not * symbol

		Assert.assertEquals(registerPage.privacyPolicyLabelColor(driver), expectedColor);

	}

	@Test(priority = 15)
	public void verifySpaceNotAllowedOnRegistedField() throws InterruptedException {

		registerPage.enterFirstName(" ");
		registerPage.enterLastName(" ");
		registerPage.enterEmail(" ");
		registerPage.enterTelephone(" ");
		registerPage.enterPassword(" ");
		registerPage.enterConfirmPassword(" ");
		registerPage.clickPrivecyPolice();
		registerPage.clickContinueButton();

		String expectedFNWarningMsg = "First Name must be between 1 and 32 characters!";
		String expectedLNWarningMsg = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarningMsg = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneWarningMsg = "Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarningMsg = "Password must be between 4 and 20 characters!";

		String actualFNWarningMsg = registerPage.firstNameWarningMsgGetText();
		String actualLNWarningMsg = registerPage.lastNameWarningMsgGetText();
		String actualEmailWaringMsg = registerPage.emailWarningMsgGetText();
		String actualTelephoneWarningMsg = registerPage.telephoneWarningMsgGetText();
		String actualPasswordWarningMsg = registerPage.passwordWarningMsgGetText();

		Assert.assertEquals(actualFNWarningMsg, expectedFNWarningMsg);
		Assert.assertEquals(actualLNWarningMsg, expectedLNWarningMsg);
		Assert.assertEquals(actualEmailWaringMsg, expectedEmailWarningMsg);
		Assert.assertEquals(actualTelephoneWarningMsg, expectedTelephoneWarningMsg);
		Assert.assertEquals(actualPasswordWarningMsg, expectedPasswordWarningMsg);

	}

	@Test(priority = 16, dataProvider = "inputPassword")
	public void verifyPasswordComplaxityStandardsOnRegisterPage(String passwordText) {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateEmail());
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(passwordText);
		registerPage.enterConfirmPassword(passwordText);
		registerPage.clickPrivecyPolice();
		registerPage.clickContinueButton();

		String expectedPwdComplaxityStandards = "Password Should conatin below values."
				+ "Password should have atleast 8 character" + "One Uppercase latter" + "One lowercase latter"
				+ "One special character";

		Assert.assertEquals(registerPage.passwordWarningMsgGetText(), expectedPwdComplaxityStandards);
		Assert.assertFalse(successPage.successBreadCrumb());
		// failing this test because invalid or uncorrected passwords are accepted

	}

	@DataProvider(name = "inputPassword")
	public Object[][] multiplePasswordDataSet() {
		Object[][] data = { { "12345" }, { "abcdefgh" }, { "abcd123" }, { "abcd123#" }, { "ADBG!123" } };
		return data;
	}

	@Test(priority = 17)
	public void verifyRegisterAccountFieldHieghtWidthAlignment() throws IOException {

		String expectedHieght = "34px";
		String actualWidth = "701.25px";

		Assert.assertEquals(registerPage.getFirstNameFieldHeight(), expectedHieght);
		Assert.assertEquals(registerPage.getFirstNameFieldWidth(), actualWidth);

		registerPage.enterFirstName("");
		registerPage.clickContinueButton();

		String expectedWarning = "First Name must be between 1 and 32 characters!";
		Assert.assertEquals(registerPage.firstNameWarningMsgGetText(), expectedWarning);

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearFirstNameField();
		registerPage.enterFirstName("P");
		registerPage.clickContinueButton();
		try {
			Assert.assertFalse(registerPage.isDisplayedFNWarningMsg());
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			// Assert.assertTrue(true);
		}

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearFirstNameField();
		registerPage.enterFirstName("Pr");
		registerPage.clickContinueButton();
		try {
			Assert.assertFalse(registerPage.isDisplayedFNWarningMsg());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearFirstNameField();
		registerPage.enterFirstName("Prajakta Naik Test");
		registerPage.clickContinueButton();
		try {
			Assert.assertFalse(registerPage.isDisplayedFNWarningMsg());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearFirstNameField();
		registerPage.enterFirstName("Prajakta Naik Test Prajakta Naik");
		registerPage.clickContinueButton();
		try {
			Assert.assertFalse(registerPage.isDisplayedFNWarningMsg());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearFirstNameField();
		registerPage.enterFirstName("Prajakta Naik Test Prajakta Naik Test");
		registerPage.clickContinueButton();
		Assert.assertEquals(registerPage.firstNameWarningMsgGetText(), expectedWarning);

		Assert.assertEquals(registerPage.getLastNameLabelHeight(), expectedHieght);
		Assert.assertEquals(registerPage.getLastNameLabelWidth(), actualWidth);

		registerPage = new RegisterAccountPage(driver);
		registerPage.enterLastName("");
		registerPage.clickContinueButton();
		String expectedLNWarning = "Last Name must be between 1 and 32 characters!";
		Assert.assertEquals(registerPage.lastNameWarningMsgGetText(), expectedLNWarning);

		registerPage = new RegisterAccountPage(driver);
		registerPage.enterLastName("P");
		registerPage.clickContinueButton();
		try {
			Assert.assertFalse(registerPage.isDisplayedLNWarningMsg());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearLastNameField();
		registerPage.enterLastName("Pr");
		registerPage.clickContinueButton();
		try {
			Assert.assertFalse(registerPage.isDisplayedLNWarningMsg());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearLastNameField();
		registerPage.enterLastName("Prajakta Naik Test");
		registerPage.clickContinueButton();
		try {
			Assert.assertFalse(registerPage.isDisplayedLNWarningMsg());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearLastNameField();
		registerPage.enterLastName("Prajakta Naik Test Prajakta Naik");
		registerPage.clickContinueButton();
		try {
			Assert.assertFalse(registerPage.isDisplayedLNWarningMsg());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearLastNameField();
		registerPage.enterLastName("Prajakta Naik Test Prajakta Naik Test");
		registerPage.clickContinueButton();
		Assert.assertEquals(registerPage.lastNameWarningMsgGetText(), expectedLNWarning);

		Assert.assertEquals(registerPage.getEmailLabelHeight(), expectedHieght);
		Assert.assertEquals(registerPage.getEmailLabelWidth(), actualWidth);

		registerPage = new RegisterAccountPage(driver);
		registerPage.enterEmail("naikprajakta124naikprajakta124naikprajakta124@gmail.com");
		registerPage.clickContinueButton();
		try {
			Assert.assertFalse(registerPage.isDisplayedEmailWarningMsg());
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			// Assert.assertTrue(true);
		}

		Assert.assertEquals(registerPage.getTelephoneLabelHeight(), expectedHieght);
		Assert.assertEquals(registerPage.getTelephoneLabelWidth(), actualWidth);

		registerPage = new RegisterAccountPage(driver);
		registerPage.enterTelephone("");
		registerPage.clickContinueButton();
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		Assert.assertEquals(registerPage.telephoneWarningMsgGetText(), expectedTelephoneWarning);

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearTelephoneField();
		registerPage.enterTelephone("12");
		registerPage.clickContinueButton();
		Assert.assertEquals(registerPage.telephoneWarningMsgGetText(), expectedTelephoneWarning);

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearTelephoneField();
		registerPage.enterTelephone("123");
		registerPage.clickContinueButton();
		try {
			Assert.assertFalse(registerPage.isDisplayedTelephoneWarningMsg());
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			Assert.assertTrue(true);
		}

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearTelephoneField();
		registerPage.enterTelephone("1234");
		registerPage.clickContinueButton();
		try {
			Assert.assertFalse(registerPage.isDisplayedTelephoneWarningMsg());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearTelephoneField();
		registerPage.enterTelephone("12345678901234567890123456789012");
		registerPage.clickContinueButton();
		try {
			Assert.assertFalse(registerPage.isDisplayedTelephoneWarningMsg());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearTelephoneField();
		registerPage.enterTelephone("1234567890123456789012345678901234");
		registerPage.clickContinueButton();
		Assert.assertEquals(registerPage.telephoneWarningMsgGetText(), expectedTelephoneWarning);

		Assert.assertEquals(registerPage.getPasswordLabelHieght(), expectedHieght);
		Assert.assertEquals(registerPage.getPasswordLabelWidth(), actualWidth);

		registerPage = new RegisterAccountPage(driver);
		registerPage.enterPassword("");
		registerPage.clickContinueButton();
		String expectedPwdWarning = "Password must be between 4 and 20 characters!";
		Assert.assertEquals(registerPage.passwordWarningMsgGetText(), expectedPwdWarning);

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearPasswordField();
		registerPage.enterPassword("pas");
		registerPage.clickContinueButton();
		Assert.assertEquals(registerPage.passwordWarningMsgGetText(), expectedPwdWarning);

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearPasswordField();
		registerPage.enterPassword("pass");
		registerPage.clickContinueButton();
		try {
			Assert.assertFalse(registerPage.isDisplayedPasswordWarningMsg());
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			// Assert.assertTrue(true);
		}

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearPasswordField();
		registerPage.enterPassword("passwordpasswordpass");
		registerPage.clickContinueButton();
		try {
			Assert.assertFalse(registerPage.isDisplayedPasswordWarningMsg());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		registerPage = new RegisterAccountPage(driver);
		registerPage.clearPasswordField();
		registerPage.enterPassword("passwordpasswordpasswordpasswordpasswordpassword");
		registerPage.clickContinueButton();
		Assert.assertEquals(registerPage.passwordWarningMsgGetText(), expectedPwdWarning);

		Assert.assertEquals(registerPage.getConfirmPasswordLabelHeight(), expectedHieght);
		Assert.assertEquals(registerPage.getConfirmPasswordLabelWidth(), actualWidth);

		prop.getProperty("URL");
		driver = nevigateToRegisterAccountPage(driver, prop.getProperty("RegisterPageURL"));
		driver = CommonUtils.takeScreenShots(driver, "\\Screenshots\\FileAlignmentActual.png");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshots = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshots,
				new File(System.getProperty("user.dir") + "\\Screenshots\\FileAlignmentActual.png"));
		Assert.assertFalse(CommonUtils.comapreThreeScreenshots(
				System.getProperty("user.dir") + "\\Screenshots\\FileAlignmentActual.png",
				System.getProperty("user.dir") + "\\Screenshots\\FileAlignmentExpected.png",
				System.getProperty("user.dir") + "\\Screenshots\\FileAlignmentExpected2.png"));

	}

	@Test(priority = 18)
	public void verifyLeadingAndTrealingSpacesOnAccountRegisterPage() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		String firstName = "   Prajakta  ";
		registerPage.enterFirstName(firstName);

		String lastName = "  Naik  ";
		registerPage.enterLastName(lastName);

		String email = "  " + CommonUtils.generateEmail() + "  ";
		registerPage.enterEmail(email);

		String telephone = "  1234567891  ";
		registerPage.enterTelephone(telephone);

		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("confirmPassword"));
		registerPage.clickPrivecyPolice();
		successPage = registerPage.clickContinueButton();
		accountPage = successPage.clickContinueButton();
		editInfoPage = accountPage.clickEditYourAccountInformation();

		softAssert.assertEquals(editInfoPage.getFirstNameAttribute(), firstName.trim());
		softAssert.assertEquals(editInfoPage.getLastNameAttribute(), lastName.trim());
		softAssert.assertEquals(editInfoPage.getEmailAttribute(), email.trim());
		softAssert.assertEquals(editInfoPage.getTelephoneAttribute(), telephone.trim());
		softAssert.assertAll();

		// Failing this test because entered values are not trimming the spaces
	}

	@Test(priority = 19)
	public void verifyPrivacyPoliceCheckboxIsUnchecked() {

		Assert.assertFalse(registerPage.isSelectedPrivacyPoliceCheckbox());

	}

	@Test(priority = 20)
	public void verifyRegisteringAccountPrivacyPoliceCheckbox() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateEmail());
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("confirmPassword"));
		registerPage.clickContinueButton();

		String expectedWarningMsg = "Warning: You must agree to the Privacy Policy!";
		Assert.assertEquals(registerPage.privacyPoliceWarningMsgGetText(), expectedWarningMsg);

	}

	@Test(priority = 21)
	public void verifyPasswordToggeledOnRegisteredAccountPage() {

		Assert.assertEquals(registerPage.getPasswordDomAttribute(), "password");
		Assert.assertEquals(registerPage.getConfirmPasswordDomAttribute(), "password");

	}

	@Test(priority = 22)
	public void verifyLinksAreClickableOnRegisterPage() throws InterruptedException {

		loginPage = registerPage.clickOnLoginPageLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		registerPage.clickOnPrivacyPoliceLink();
		Assert.assertTrue(registerPage.isDisplayedPrivacyPoliceText());
		registerPage.clickcrossIconOnPrivacyPolivePopup();

		contactPage = registerPage.clickTelephoneIcon();
		Assert.assertTrue(contactPage.isDisplayedContactUsBreadCrumb());
		driver.navigate().back();

		registerPage.clickMyAccount();
		Assert.assertTrue(registerPage.RegisterLinkDisplayed());
		Assert.assertTrue(registerPage.isDisplayedLoginOption());

		loginPage = registerPage.clickOnWishList();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		shoppingCartPage = registerPage.clickShoppingCart();
		Assert.assertTrue(shoppingCartPage.isDisplayedShoppingCartBreadCrumb());
		driver.navigate().back();

		shoppingCartPage = registerPage.clickCheckout();
		Assert.assertTrue(shoppingCartPage.isDisplayedShoppingCartBreadCrumb());
		driver.navigate().back();

		registerPage.clickLogo();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("HomePageURL"));
		driver.navigate().back();

		Thread.sleep(3000);
		loginPage = registerPage.clickLoginLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		registerPage.clickRegisterLink();
		Assert.assertTrue(registerPage.displayedBreadCrumbOnRegisterAccountPage());

		forgotPasswordPage = registerPage.clickForgotPassword();
		Assert.assertTrue(forgotPasswordPage.isDisplayedForgotPasswordBreadCrumb());
		driver.navigate().back();

		loginPage = registerPage.clickMyAccountLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		loginPage = registerPage.clickAddressBookLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		loginPage = registerPage.clickWishListLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		loginPage = registerPage.clickOrderHistoryLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		loginPage = registerPage.clickDownloadsLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		loginPage = registerPage.clickRecuringPaymentLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		registerPage.clickRewardPointsLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		loginPage = registerPage.clickReturnsLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		loginPage = registerPage.clickTransactionsLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		loginPage = registerPage.clickNewsletterLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		aboutUsPage = registerPage.clickAboutUsFooterLink();
		Assert.assertTrue(aboutUsPage.isDisplayedAboutUsBreadCrumb());
		driver.navigate().back();

		deliveryInfoPage = registerPage.clickDeliveryInformationFooterLink();
		Assert.assertTrue(deliveryInfoPage.isDisplayedDeliveryInformationBreadCrumb());
		driver.navigate().back();

		privacyPolicePage = registerPage.clickPrivacyPloiceFooterLink();
		Assert.assertTrue(privacyPolicePage.isDisplayedPrivacyPoliceFooterLink());
		driver.navigate().back();

		termsAndConditionPage = registerPage.clickTermsAndConditionsFooterLink();
		Assert.assertTrue(termsAndConditionPage.isDisplayedTermsAndConditions());
		driver.navigate().back();

		contactPage = registerPage.clickContactUsFooterLink();
		Assert.assertTrue(contactPage.isDisplayedContactUsBreadCrumb());
		driver.navigate().back();

		productReturnsPage = registerPage.clickReturnsFooterLink();
		Assert.assertTrue(productReturnsPage.isDisplayedProductReturnsFooterLink());
		driver.navigate().back();

		siteMapPage = registerPage.clickSiteMapFooterLink();
		Assert.assertTrue(siteMapPage.isDisplayedSiteMapBreadCrumb());
		driver.navigate().back();

		brandPage = registerPage.clickBrandsFooterLink();
		Assert.assertTrue(brandPage.isDisplayedBrandBreadCrumb());
		driver.navigate().back();

		giftCertificatePage = registerPage.clickGiftCertificateFooterLink();
		Assert.assertTrue(giftCertificatePage.isDisplayedGiftCertificateBreadcrumb());
		driver.navigate().back();

		affiliatePage = registerPage.clickAffiliateFooterLink();
		Assert.assertTrue(affiliatePage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		specialOfferPage = registerPage.clickSpecialFooterLink();
		Assert.assertTrue(specialOfferPage.isDisplayedSpecialOffersBreadCrumb());
		driver.navigate().back();

		loginPage = registerPage.clickMyAccountFooterLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		loginPage = registerPage.clickOrderHistoryFooterLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		loginPage = registerPage.clickWishListFooterLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		loginPage = registerPage.clickNewsletterFooterLink();
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		driver.navigate().back();

		registerPage.clickOpenCartFooterLink();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("OpenCartUrl"));
		driver.navigate().back();

	}

	@Test(priority = 23)
	public void verifyConfirmPasswordField() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateEmail());
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.clickPrivecyPolice();
		registerPage.clickContinueButton();

		String expectedWarningMsg = "Password confirmation does not match password!";
		Assert.assertEquals(registerPage.getTextConfirmPasswordWarningMsg(), expectedWarningMsg);
	}

	@Test(priority = 24)
	public void verifyBreadcrumURLTitleHeadingOnRegisterAccountPage() {

		Assert.assertEquals(driver.getTitle(), prop.getProperty("RegisterAccountTitle"));
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("RegisterPageURL"));
		Assert.assertTrue(registerPage.isDisaplyedHomeBreadCrumbIcon());
		Assert.assertTrue(registerPage.isDisplayedAccountBreadCrumb());
		Assert.assertTrue(registerPage.displayedBreadCrumbOnRegisterAccountPage());
		Assert.assertEquals(registerPage.getTextHeadingRegisterAccount(), "Register Account");

	}

	@Test(priority = 25)
	public void verifyRegisterAccountPageUI() throws IOException {

		CommonUtils.takeScreenShots(driver, "\\Screenshots\\actualUICheck.png");
		Assert.assertFalse(
				CommonUtils.comapreThreeScreenshots(System.getProperty("user.dir") + "\\Screenshots\\actualUICheck.png",
						System.getProperty("user.dir") + "\\Screenshots\\expectedUICheck.png",
						System.getProperty("user.dir") + "\\Screenshots\\expectedUICheck2.png"));

	}

	@Test(priority = 26)
	public void verifyRegisteringAccountOnDifferentEnvironments() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateEmail());
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("confirmPassword"));
		registerPage.clickPrivecyPolice();
		successPage = registerPage.clickContinueButton();

		Assert.assertTrue(successPage.logout());

		Assert.assertEquals(successPage.HeaderMessage(), "Your Account Has Been Created!");

		String actualProperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String actualProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDetailsFour = "contact us";

		String expectedProperDetails = successPage.RegisteredSuccessfulyMsg();

		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsOne));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsTwo));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsThree));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsFour));

		accountPage = successPage.clickContinueButton();

		Assert.assertTrue(accountPage.EditYourAccountInformation());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
