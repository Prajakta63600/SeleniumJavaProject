package tutorialninja.register;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.baseClass;
import utils.CommonUtils;

public class TC_016 extends baseClass {
	Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifySpaceNotAllowedOnRegistedField() throws InterruptedException {
		driver.findElement(By.id("input-firstname")).sendKeys(" ");
		driver.findElement(By.id("input-lastname")).sendKeys(" ");
		driver.findElement(By.id("input-email")).sendKeys(" ");
		driver.findElement(By.id("input-telephone")).sendKeys(" ");
		driver.findElement(By.id("input-password")).sendKeys(" ");
		driver.findElement(By.id("input-confirm")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String expectedFNWarningMsg = "First Name must be between 1 and 32 characters!";
		String expectedLNWarningMsg = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarningMsg = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneWarningMsg = "Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarningMsg = "Password must be between 4 and 20 characters!";

		String actualFNWarningMsg = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		System.out.println(actualFNWarningMsg);
		String actualLNWarningMsg = driver
				.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']")).getText();
		String actualEmailWaringMsg = driver
				.findElement(By.xpath("//div[text()='E-Mail Address does not appear to be valid!']")).getText();
		String actualTelephoneWarningMsg = driver
				.findElement(By.xpath("//div[text()='Telephone must be between 3 and 32 characters!']")).getText();
		String actualPasswordWarningMsg = driver
				.findElement(By.xpath("//div[text()='Password must be between 4 and 20 characters!']")).getText();

		Assert.assertEquals(actualFNWarningMsg, expectedFNWarningMsg);
		Assert.assertEquals(actualLNWarningMsg, expectedLNWarningMsg);
		Assert.assertEquals(actualEmailWaringMsg, expectedEmailWarningMsg);
		Assert.assertEquals(actualTelephoneWarningMsg, expectedTelephoneWarningMsg);
		Assert.assertEquals(actualPasswordWarningMsg, expectedPasswordWarningMsg);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
