package tutorialninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_009 {
	
	@Test
	public static void verifyRegisterNewUserWithExistingEmail()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Tony");
		driver.findElement(By.id("input-lastname")).sendKeys("Stark");
		driver.findElement(By.id("input-email")).sendKeys("tony@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("4533333333");
		driver.findElement(By.id("input-password")).sendKeys("tony123");
		driver.findElement(By.id("input-confirm")).sendKeys("tony123");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualWarningMessage= driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedWarningMessage= "Warning: E-Mail Address is already registered!";
		if(actualWarningMessage.contains(expectedWarningMessage))
			{
				System.out.println("Warning message is displayed");
			}
		else
			{
				System.out.println("Warning message is not displayed");
			}
		
				driver.quit();

}
	
}
