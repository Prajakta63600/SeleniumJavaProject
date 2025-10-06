package tutorialninja.register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;

import Base.baseClass;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import utils.CommonUtils;

public class TC_010 extends baseClass {
	Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		driver = openBrowserAndApplication();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifyEmailFieldWithDifferentData() throws IOException, InterruptedException {

		String browserName = "firefox";
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys("tony");
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("confirmPassword"));
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		if (browserName.equals("chrome")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"Please include an '@' in the email address. 'tony' is missing an '@'.");
		} else if (browserName.equals("edge")) {
			System.out.println(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"));
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"Please include an '@' in the email address. 'tony' is missing an '@'.");
		} else if (browserName.equals("firefox")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"Please enter an email address.");
		}

		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("tony@gmail.");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		if (browserName.equals("firefox")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"Please enter an email address.");
		} else if (browserName.equals("chrome")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"'.' is used at a wrong position in 'gmail.'.");
		} else if (browserName.equals("edge")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"'.' is used at a wrong position in 'gmail.'.");
		}

		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("tony@");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		if (browserName.equals("firefox")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"Please enter an email address.");
		} else if (browserName.equals("chrome")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"Please enter a part following '@'. 'tony@' is incomplete.");
		} else if (browserName.equals("edge")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"Please enter a part following '@'. 'tony@' is incomplete.");
		}

		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("tony@gmail");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(),
				"E-Mail Address does not appear to be valid!");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
