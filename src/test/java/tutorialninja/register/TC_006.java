package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_006 {
	
	@Test
	public void verifyNevigateToRegisterPage()
	
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), "Register Account");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), "Register Account");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), "Register Account");
		
		driver.findElement(By.linkText("Register")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), "Register Account");
		
		driver.quit();
		
		
	}

}
