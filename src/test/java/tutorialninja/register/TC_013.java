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

public class TC_013 extends baseClass {
	Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		driver = openBrowserAndApplication();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifyRegisterPagePlaceholder() {
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder = 'First Name']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder = 'Last Name']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder = 'E-Mail']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder = 'Telephone']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder = 'Password']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder = 'Password Confirm']")).isDisplayed());
//	    boolean firstNamePlaceholder = driver.findElement(By.xpath("//input[@placeholder = 'First Name']")).isDisplayed();
//	  System.out.println(firstNamePlaceholder);   
//	  
//	  boolean lastNamePlaceholder = driver.findElement(By.xpath("//input[@placeholder = 'Last Name']")).isDisplayed();
//	  System.out.println(lastNamePlaceholder);
//	  
//	 boolean emailPlaceholder= driver.findElement(By.xpath("//input[@placeholder = 'E-Mail']")).isDisplayed();
//	 System.out.println(emailPlaceholder);
//	 
//	 boolean telephonePlaceholder = driver.findElement(By.xpath("//input[@placeholder = 'Telephone']")).isDisplayed();
//	 System.out.println(telephonePlaceholder);
//	 
//	 boolean passwordPlaceholder = driver.findElement(By.xpath("//input[@placeholder = 'Password']")).isDisplayed();
//	 System.out.println(passwordPlaceholder);
//	 
//	 boolean confirmPasswordPlaceholder = driver.findElement(By.xpath("//input[@placeholder = 'Password Confirm']")).isDisplayed();
//	 System.out.println(confirmPasswordPlaceholder);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
