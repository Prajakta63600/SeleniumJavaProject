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
import utils.CommonUtils;

public class TC_017 extends baseClass {

	Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test(dataProvider = "inputPassword")
	public void verifyPasswordComplaxityStandardsOnRegisterPage(String passwordText) {
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(passwordText);
		driver.findElement(By.id("input-confirm")).sendKeys(passwordText);
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String expectedPwdComplaxityStandards = "Password Should conatin below values."
				+ "Password should have atleast 8 character" + "One Uppercase latter" + "One lowercase latter"
				+ "One special character";

		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='password']/following-sibling::div")).getText(),
				expectedPwdComplaxityStandards);
		Assert.assertFalse(driver.findElement(By.linkText("Success")).isDisplayed());
		//failing this test because invalid or uncorrected passwords are accepted

	}

	@DataProvider(name = "inputPassword")
	public Object[][] multiplePasswordDataSet() {
		Object[][] data = { { "12345" }, { "abcdefgh" }, { "abcd123" }, { "abcd123#" }, { "ADBG!123" } };
		return data;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
