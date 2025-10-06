package tutorialninja.register;

import java.time.Duration;
import java.util.Date;
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

public class TC_002 extends baseClass {

	Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
	}

	@Test
	public void verifyRegisterSuccesfullPage() {

		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("confirmPassword"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value = 'Continue']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.linkText("Success")).isDisplayed());

		String actualProperDetails0 = "Your Account Has Been Created!";
		String actualProperDetails1 = "Congratulations! Your new account has been successfully created!";
		String actualProperDetails2 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetails3 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDetails4 = "contact us";

		String expectedProperDetails = driver.findElement(By.xpath("//div[@id= 'content']")).getText();

		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails0));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails1));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails2));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails3));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails4));

		driver.findElement(By.linkText("Continue")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
