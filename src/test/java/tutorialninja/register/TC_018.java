package tutorialninja.register;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.baseClass;
import utils.CommonUtils;

public class TC_018 extends baseClass {
	Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifyRegisterAccountFieldHieghtWidthAlignment() throws IOException {

		String expectedHieght = "34px";
		String actualWidth = "701.25px";
		WebElement firstNameField = driver.findElement(By.id("input-firstname"));
		String actualFNHeight = firstNameField.getCssValue("height");
		String actualFNWidth = firstNameField.getCssValue("width");
		Assert.assertEquals(actualFNHeight, expectedHieght);
		Assert.assertEquals(actualFNWidth, actualWidth);

		firstNameField.sendKeys("");
		WebElement clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		clickButton.click();

		String expectedWarning = "First Name must be between 1 and 32 characters!";
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(),
				expectedWarning);

		firstNameField = driver.findElement(By.id("input-firstname"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		firstNameField.clear();
		firstNameField.sendKeys("P");
		clickButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div"))
					.isDisplayed());
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			// Assert.assertTrue(true);
		}

		firstNameField = driver.findElement(By.id("input-firstname"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		firstNameField.clear();
		firstNameField.sendKeys("Pr");
		clickButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div"))
					.isDisplayed());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		firstNameField = driver.findElement(By.id("input-firstname"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		firstNameField.clear();
		firstNameField.sendKeys("Prajakta Naik Test");
		clickButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div"))
					.isDisplayed());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		firstNameField = driver.findElement(By.id("input-firstname"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		firstNameField.clear();
		firstNameField.sendKeys("Prajakta Naik Test Prajakta Naik");
		clickButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div"))
					.isDisplayed());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		firstNameField = driver.findElement(By.id("input-firstname"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		firstNameField.clear();
		firstNameField.sendKeys("Prajakta Naik Test Prajakta Naik Test");
		clickButton.click();
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(),
				expectedWarning);

		WebElement lastNameField = driver.findElement(By.id("input-lastname"));
		String actualLNHeight = lastNameField.getCssValue("height");
		String actaulLNWidth = lastNameField.getCssValue("width");
		Assert.assertEquals(actualLNHeight, expectedHieght);
		Assert.assertEquals(actaulLNWidth, actualWidth);

		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		lastNameField.sendKeys("");
		clickButton.click();
		String expectedLNWarning = "Last Name must be between 1 and 32 characters!";
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(),
				expectedLNWarning);

		lastNameField = driver.findElement(By.id("input-lastname"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		lastNameField.sendKeys("P");
		clickButton.click();
		try {
			Assert.assertFalse(
					driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		lastNameField = driver.findElement(By.id("input-lastname"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		lastNameField.clear();
		lastNameField.sendKeys("Pr");
		clickButton.click();
		try {
			Assert.assertFalse(
					driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		lastNameField = driver.findElement(By.id("input-lastname"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		lastNameField.clear();
		lastNameField.sendKeys("Prajakta Naik Test");
		clickButton.click();
		try {
			Assert.assertFalse(
					driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		lastNameField = driver.findElement(By.id("input-lastname"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		lastNameField.clear();
		lastNameField.sendKeys("Prajakta Naik Test Prajakta Naik");
		clickButton.click();
		try {
			Assert.assertFalse(
					driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		lastNameField = driver.findElement(By.id("input-lastname"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		lastNameField.clear();
		lastNameField.sendKeys("Prajakta Naik Test Prajakta Naik Test");
		clickButton.click();
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(),
				expectedLNWarning);

		WebElement emailField = driver.findElement(By.id("input-email"));
		String actualEamilHeight = emailField.getCssValue("height");
		String actualEmailWidth = emailField.getCssValue("width");
		Assert.assertEquals(actualEamilHeight, expectedHieght);
		Assert.assertEquals(actualEmailWidth, actualWidth);

		emailField = driver.findElement(By.id("input-email"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		emailField.sendKeys("naikprajakta124naikprajakta124naikprajakta124@gmail.com");
		clickButton.click();
		try {
			Assert.assertFalse(
					driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).isDisplayed());
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			// Assert.assertTrue(true);
		}

		WebElement telephoneField = driver.findElement(By.id("input-telephone"));
		String actualTelephoneHeight = telephoneField.getCssValue("height");
		String actualTelephoneWidth = telephoneField.getCssValue("width");
		Assert.assertEquals(actualTelephoneHeight, expectedHieght);
		Assert.assertEquals(actualTelephoneWidth, actualWidth);

		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		telephoneField.sendKeys("");
		clickButton.click();
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),
				expectedTelephoneWarning);

		telephoneField = driver.findElement(By.id("input-telephone"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		telephoneField.clear();
		telephoneField.sendKeys("12");
		clickButton.click();
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),
				expectedTelephoneWarning);

		telephoneField = driver.findElement(By.id("input-telephone"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		telephoneField.clear();
		telephoneField.sendKeys("123");
		clickButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div"))
					.isDisplayed());
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			Assert.assertTrue(true);
		}

		telephoneField = driver.findElement(By.id("input-telephone"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		telephoneField.clear();
		telephoneField.sendKeys("1234");
		clickButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div"))
					.isDisplayed());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		telephoneField = driver.findElement(By.id("input-telephone"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		telephoneField.clear();
		telephoneField.sendKeys("12345678901234567890123456789012");
		clickButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div"))
					.isDisplayed());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		telephoneField = driver.findElement(By.id("input-telephone"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		telephoneField.clear();
		telephoneField.sendKeys("1234567890123456789012345678901234");
		clickButton.click();
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),
				expectedTelephoneWarning);

		WebElement passwordField = driver.findElement(By.id("input-password"));
		String actualPwdHeight = passwordField.getCssValue("height");
		String actualPwdWidth = passwordField.getCssValue("width");
		Assert.assertEquals(actualPwdHeight, expectedHieght);
		Assert.assertEquals(actualPwdWidth, actualWidth);

		passwordField = driver.findElement(By.id("input-password"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		passwordField.sendKeys("");
		clickButton.click();
		String expectedPwdWarning = "Password must be between 4 and 20 characters!";
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),
				expectedPwdWarning);

		passwordField = driver.findElement(By.id("input-password"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		passwordField.clear();
		passwordField.sendKeys("pas");
		clickButton.click();
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),
				expectedPwdWarning);

		passwordField = driver.findElement(By.id("input-password"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		passwordField.clear();
		passwordField.sendKeys("pass");
		clickButton.click();
		try {
			Assert.assertFalse(
					driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			// Assert.assertTrue(true);
		}

		passwordField = driver.findElement(By.id("input-password"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		passwordField.clear();
		passwordField.sendKeys("passwordpasswordpass");
		clickButton.click();
		try {
			Assert.assertFalse(
					driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

		passwordField = driver.findElement(By.id("input-password"));
		clickButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		passwordField.clear();
		passwordField.sendKeys("passwordpasswordpasswordpasswordpasswordpassword");
		clickButton.click();
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),
				expectedPwdWarning);

		String actualPwdConfirmHeight = driver.findElement(By.id("input-confirm")).getCssValue("height");
		String actualPwdConfirmWidth = driver.findElement(By.id("input-confirm")).getCssValue("width");
		Assert.assertEquals(actualPwdConfirmHeight, expectedHieght);
		Assert.assertEquals(actualPwdConfirmWidth, actualWidth);

		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/register");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshots = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshots,
				new File(System.getProperty("user.dir") + "\\Screenshots\\FileAlignmentActual.png"));
		Assert.assertFalse(CommonUtils.comapreThreeScreenshots(
				System.getProperty("user.dir") + "\\Screenshots\\FileAlignmentActual.png",
				System.getProperty("user.dir") + "\\Screenshots\\FileAlignmentExpected.png", System.getProperty("user.dir") + "\\Screenshots\\FileAlignmentExpected2.png"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
