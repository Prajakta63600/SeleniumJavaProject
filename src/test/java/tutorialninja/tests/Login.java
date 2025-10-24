package tutorialninja.tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AccountLogoutPage;
import Pages.AccountPage;
import Pages.ForgotPasswordPage;
import Pages.HomePage;
import Pages.LoginPage;
import tutorialninja.base.baseClass;
import utils.CommonUtils;

public class Login extends baseClass {

	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	AccountPage accountPage;
	ForgotPasswordPage forgotPassword;
	AccountLogoutPage logoutPage;

	@BeforeMethod
	public void setUp() {

		driver = openBrowserAndApplication();
		prop = CommonUtils.loadProperties();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();

	}

	@Test(priority = 1)
	public void verifyLoginWithValidCradentials() {

		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());

		loginPage.enterEmailField(prop.getProperty("email"));
		loginPage.enterPwdField(prop.getProperty("password"));
		accountPage = loginPage.clickLoginButton();
		Assert.assertTrue(accountPage.isDisplayedAccountBreadCrumb());
		Assert.assertEquals(loginPage.getTextLogoutLink(), "Logout");

	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCradentials() {

		loginPage.enterEmailField(prop.getProperty("invalidEmail"));
		loginPage.enterPwdField(prop.getProperty("invalidPassword"));
		accountPage = loginPage.clickLoginButton();

		String expectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.getTextNoMatcharningMsg(), expectedWarningMsg);
	}

	@Test(priority = 3)
	public void verifyInvalidEmailAndValidPassword() {
		loginPage.enterEmailField(prop.getProperty("invalidEmail"));
		loginPage.enterPwdField(prop.getProperty("password"));
		accountPage = loginPage.clickLoginButton();

		String expectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.getTextNoMatcharningMsg(), expectedWarningMsg);
	}

	@Test(priority = 4)
	public void verifyValidEmailAndInvalidPassword() {
		loginPage.enterEmailField(prop.getProperty("email"));
		loginPage.enterPwdField(prop.getProperty("invalidPassword"));
		accountPage = loginPage.clickLoginButton();

		String expectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.getTextNoMatcharningMsg(), expectedWarningMsg);
	}

	@Test(priority = 5)
	public void verifyLoginWithEmptyFields() {
		loginPage.enterEmailField("");
		loginPage.enterPwdField("");
		accountPage = loginPage.clickLoginButton();

		String expectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.getTextNoMatcharningMsg(), expectedWarningMsg);
	}

	@Test(priority = 6)
	public void verifyForgotPasswordLink() {

		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());
		Assert.assertTrue(loginPage.isDisplayedForgotPassword());

		forgotPassword = loginPage.clickForgotPassword();

		Assert.assertTrue(forgotPassword.isDisplayedForgotPasswordBreadCrumb());
		Assert.assertEquals(forgotPassword.getTextTitleForgotPassword(), "Forgot Your Password?");

	}

	@Test(priority = 7)
	public void verifyLoginToAppUsingTabButton() {

		driver = pressTabButtonMultipleTime(driver, Keys.TAB, 23);
		Actions action = new Actions(driver);

		action.sendKeys(prop.getProperty("email")).sendKeys(Keys.TAB).sendKeys(prop.getProperty("password"))
				.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).pause(Duration.ofSeconds(3)).build()
				.perform();
		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.isDisplayedAccountBreadCrumb());
		Assert.assertTrue(accountPage.EditYourAccountInformation());
	}

	@Test(priority = 8)
	public void verifyPlaceHolderOnLoginAndPasswordField() {

		Assert.assertTrue(loginPage.getEmailPlaceholder());
		Assert.assertTrue(loginPage.getPwdPlaceholder());
	}

	@Test(priority = 9)
	public void verifyUserSatysLoggedInAfterClickingBlackBrowserArrow() throws InterruptedException {
		loginPage.enterEmailField(prop.getProperty("email"));
		loginPage.enterPwdField(prop.getProperty("password"));
		loginPage.clickLoginButton();
		driver = nevigateBack(driver);
		loginPage = new LoginPage(driver);
		accountPage = loginPage.clickMyAccountRightOption();
		Assert.assertEquals(accountPage.getTextLogoutRightOption(), "Logout");
	}

	@Test(priority = 10)
	public void verifyBrowserBackAfterLoggingOut() {

		loginPage.enterEmailField(prop.getProperty("email"));
		loginPage.enterPwdField(prop.getProperty("password"));
		accountPage = loginPage.clickLoginButton();
		logoutPage = accountPage.clickLogoutRightOption();
		logoutPage = new AccountLogoutPage(driver);
		driver = nevigateBack(driver);
		accountPage = new AccountPage(driver);
		accountPage.clickEditYourAccountInformation();
		loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.isDisplayedLoginBreadCrumb());

	}
	
	@Test(priority = 11)
	public void verifyLoginWithInactiveCredentials() {
		
		loginPage.enterEmailField(CommonUtils.generateEmail());
		loginPage.enterPwdField(prop.getProperty("invalidPassword"));
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getTextNoMatcharningMsg(), "Warning: No match for E-Mail Address and/or Password.");
	}
	
	@Test(priority = 12)
	public void verifyLoginAttemptExceededWarningMsg() throws InterruptedException
	{
		loginPage.enterEmailField(CommonUtils.generateEmail());
		loginPage.enterPwdField("invalidPassword");
		loginPage.clickLoginButton();
		Thread.sleep(3000);
		loginPage.clickLoginButton();
		loginPage.clickLoginButton();
		loginPage.clickLoginButton();
		loginPage.clickLoginButton();
		loginPage.clickLoginButton();
		String expectedMsg= "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
		Assert.assertEquals(loginPage.getTextAttemptExceedWarningMsg(), expectedMsg);
	}
	
	@Test(priority = 13)
	public void verifyPasswordEneterdHaveToggeled() {
		
		String expectedType = "password";
		Assert.assertEquals(loginPage.getPasswordDOmAttributeType(), expectedType);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
