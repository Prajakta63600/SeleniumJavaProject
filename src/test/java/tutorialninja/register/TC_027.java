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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.baseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CommonUtils;

public class TC_027 extends baseClass {
	Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	}

	@Test
	public void verifyRegisteringAccountOnDifferentEnvironments() {

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(CommonUtils.generateEmail());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop.getProperty("telephone"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("confirmPassword"));

		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//aside[@id='column-right']//a[normalize-space()='Logout']"))
				.isDisplayed());

		String actualRegisterSuccessDetails = driver
				.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(actualRegisterSuccessDetails, "Your Account Has Been Created!");

		String actualProperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String actualProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDetailsFour = "contact us";

		String expectedProperDetails = driver.findElement(By.xpath("//div[@id='content']")).getText();

		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsOne));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsTwo));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsThree));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsFour));

		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//a[normalize-space()='Edit your account information']")).isDisplayed());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
