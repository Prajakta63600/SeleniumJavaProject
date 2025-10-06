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

public class TF_003 extends baseClass {
	Properties prop;
	
	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifyValidationMessageOnRegisterPage() throws InterruptedException {

		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(5000);

		String FirstNameError = driver.findElement(By.xpath("//input[@id ='input-firstname']/following-sibling::div"))
				.getText();

		Assert.assertTrue(FirstNameError.contains("First Name must be between 1 and 32 characters!"));
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id ='input-lastname']/following-sibling::div")).getText(),
				"Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id ='input-email']/following-sibling::div")).getText(),
				"E-Mail Address does not appear to be valid!");
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id ='input-telephone']/following-sibling::div")).getText(),
				"Telephone must be between 3 and 32 characters!");
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id ='input-password']/following-sibling::div")).getText(),
				"Password must be between 4 and 20 characters!");
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),
				"Warning: You must agree to the Privacy Policy!");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
