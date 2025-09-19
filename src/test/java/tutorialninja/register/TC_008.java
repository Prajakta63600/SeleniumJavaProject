package tutorialninja.register;


import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class TC_008 {
	
	@Test
	public static void verifyRegisterNewUserWithWrongPassword()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Tony");
		driver.findElement(By.id("input-lastname")).sendKeys("Stark");
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("2345555555");
		driver.findElement(By.id("input-password")).sendKeys("tony123");
		driver.findElement(By.id("input-confirm")).sendKeys("tony132");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(), "Password confirmation does not match password!");
		
		driver.quit();
	}
	

	
}
