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
import org.testng.asserts.SoftAssert;

import Base.baseClass;
import utils.CommonUtils;

public class TC_019 extends baseClass {

	Properties prop;

	@BeforeMethod
	public void setUp() {

		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifyLeadingAndTrealingSpacesOnAccountRegisterPage() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		String firstName = "   Prajakta  ";
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);

		String lastName = "  Naik  ";
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);

		String email = "  " + CommonUtils.generateEmail() + "  ";
		driver.findElement(By.id("input-email")).sendKeys(email);

		String telephone = "  1234567891  ";
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);

		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.linkText("Edit your account information")).click();

		softAssert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("value"), firstName.trim());
		softAssert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("value"), lastName.trim());
		softAssert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("value"), email.trim());
		softAssert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("value"), telephone.trim());
		softAssert.assertAll();
		
		//Failing this test because entered values are not trimming the spaces
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	// On firefox browser test will fail because there is a defect.
	// this test will fail as lading and trealing spaces are not been trimed

}
