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

public class TC_006 extends baseClass {

	Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifyNevigateToRegisterPage()

	{

		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), "Register Account");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), "Register Account");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), "Register Account");

		driver.findElement(By.linkText("Register")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), "Register Account");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
