package tutorialninja.register;

import java.util.Date;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_005 {
	
	@Test
	public void verifyRegisterWithNoSubscribtion()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Prajakta");
		driver.findElement(By.id("input-lastname")).sendKeys("Naik");
		driver.findElement(By.id("input-email")).sendKeys(generateEmailTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("7789654321");
		driver.findElement(By.id("input-password")).sendKeys("333@33");
		driver.findElement(By.id("input-confirm")).sendKeys("333@33");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		Assert.assertTrue(driver.findElement(By.linkText("Success")).isDisplayed());
		
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Newsletter")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='0']")).isSelected());
		
		driver.quit();
		
	}
	
	public static String generateEmailTimeStamp()
	{
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
	}

}
