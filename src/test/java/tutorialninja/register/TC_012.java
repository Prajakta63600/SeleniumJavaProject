package tutorialninja.register;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.baseClass;
import utils.CommonUtils;

public class TC_012 extends baseClass {
	Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifyRegisterAccountPageUsingKeyboardKeys() {

		Actions actions = new Actions(driver);
		for (int i = 0; i < 23; i++) {
			actions.sendKeys(Keys.TAB).perform();
		}

		actions.sendKeys(prop.getProperty("firstName")).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("lastName")).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(CommonUtils.generateEmail()).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("telephone")).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(prop.getProperty("password")).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("confirmPassword")).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
				.sendKeys(Keys.SPACE).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).perform();

		Assert.assertEquals(driver.findElement(By.linkText("Logout")).getText(), "Logout");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h1")).isDisplayed());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
