package tutorialninja.register;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_010_03 {

	@Test
	public void verifyEmailFieldWithDifferentData3(){
		
		//System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Tony");
		driver.findElement(By.id("input-lastname")).sendKeys("Stark");
		driver.findElement(By.id("input-email")).sendKeys("tony@gmail");
		driver.findElement(By.id("input-telephone")).sendKeys("2345555555");
		driver.findElement(By.id("input-password")).sendKeys("tony123");
		driver.findElement(By.id("input-confirm")).sendKeys("tony123");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(), "E-Mail Address does not appear to be valid!");
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("tony@gmail.");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		driver.quit();
	}
}