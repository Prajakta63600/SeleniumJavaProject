package tutorialninja.register;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.baseClass;
import utils.CommonUtils;

public class Tc_014 extends baseClass {
	Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifyRegisterPageFieldName() {
		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";

		// FirstName Astrick and color
		WebElement firstName = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String fNContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", firstName);
		// System.out.println(fNContent);
		String fNColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", firstName);
		// System.out.println(fNColor);
		Assert.assertEquals(fNContent, expectedContent);
		Assert.assertEquals(fNColor, expectedColor);

		// LastName Astrick and color
		WebElement lastName = driver.findElement(By.cssSelector("label[for='input-lastname']"));
		String lNContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", lastName);
		String lNColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", lastName);
		// System.out.println(lNContent+" and "+lNColor);
		Assert.assertEquals(lNContent, expectedContent);
		Assert.assertEquals(lNColor, expectedColor);

		// Email astrik and color
		WebElement email = driver.findElement(By.cssSelector("label[for='input-email']"));
		String emailContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", email);
		String emailColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", email);
		Assert.assertEquals(emailContent, expectedContent);
		Assert.assertEquals(emailColor, expectedColor);

		// Telephone astrik and color
		WebElement telephone = driver.findElement(By.cssSelector("label[for='input-telephone']"));
		String telephoneContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", telephone);
		String telephoneColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", telephone);
		Assert.assertEquals(telephoneContent, expectedContent);
		Assert.assertEquals(telephoneColor, expectedColor);

		// Password field
		WebElement password = driver.findElement(By.cssSelector("label[for='input-password']"));
		String passwordContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", password);
		String passwordColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", password);
		Assert.assertEquals(passwordContent, expectedContent);
		Assert.assertEquals(passwordColor, expectedColor);

		// Confirm Password field
		WebElement confirmPwd = driver.findElement(By.cssSelector("label[for='input-confirm']"));
		String confirmPwdContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", confirmPwd);
		String confirmPwdColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", confirmPwd);
		Assert.assertEquals(confirmPwdContent, expectedContent);
		Assert.assertEquals(confirmPwdColor, expectedColor);

		// Privacy Police
		WebElement privacyPolice = driver.findElement(By.cssSelector("a[class='agree'] b"));
		String privacyPoliceContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", privacyPolice);
		String privacyPoliceColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", privacyPolice);
		Assert.assertEquals(privacyPoliceContent, expectedContent);
		// failing script here because privacy police as not * symbol
																
		Assert.assertEquals(privacyPoliceColor, expectedColor);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
