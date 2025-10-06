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

public class TC_025 extends baseClass {
	Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifyBreadcrumURLTitleHeadingOnRegisterAccountPage() {

		Assert.assertEquals(driver.getTitle(), "Register Account");
		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=account/register");
		Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-home']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Account']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(), 'Register')]"))
				.isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Register Account']")).getText(),
				"Register Account");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
