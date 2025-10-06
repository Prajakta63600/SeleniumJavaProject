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

public class TC_008 extends baseClass {
	Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifyRegisterNewUserWithWrongPassword() {

		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("input-confirm")).sendKeys("tony132");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(),
				"Password confirmation does not match password!");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
