package tutorialninja.register;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.baseClass;
import utils.CommonUtils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TC_026 extends baseClass {
	Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifyRegisterAccountPageUI() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshots = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshots, new File(System.getProperty("user.dir") + "\\Screenshots\\actualUICheck.png"));

		Assert.assertFalse(
				CommonUtils.comapreThreeScreenshots(System.getProperty("user.dir") + "\\Screenshots\\actualUICheck.png",
						System.getProperty("user.dir") + "\\Screenshots\\expectedUICheck.png",
						System.getProperty("user.dir") + "\\Screenshots\\expectedUICheck2.png"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
