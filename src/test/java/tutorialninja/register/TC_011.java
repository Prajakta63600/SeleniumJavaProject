package tutorialninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class TC_011 {
	WebDriver driver;
	
	@Test
	public void verifyInvalidTelephoneNumber()
	{
		 driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		 driver.findElement(By.linkText("My Account")).click();
	        driver.findElement(By.linkText("Register")).click();
	        driver.findElement(By.id("input-firstname")).sendKeys("Tony");
	        driver.findElement(By.id("input-lastname")).sendKeys("Stark");
	        driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateEmail());
	        driver.findElement(By.id("input-telephone")).sendKeys("abcdef");
	        driver.findElement(By.id("input-password")).sendKeys("tony123");
	        driver.findElement(By.id("input-confirm")).sendKeys("tony123");
	        driver.findElement(By.xpath("//input[@name='agree']")).click();
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();
	        
	        String expectedMessage = "Telephone Number dose not appear to be valid";
	        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedMessage);
	        
	        
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
