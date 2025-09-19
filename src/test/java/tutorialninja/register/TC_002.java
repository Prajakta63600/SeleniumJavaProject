package tutorialninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import utils.CommonUtils;

public class TC_002 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Prajakta");
		driver.findElement(By.id("input-lastname")).sendKeys("Naik");
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234566789");
		driver.findElement(By.id("input-password")).sendKeys("123@34");
		driver.findElement(By.id("input-confirm")).sendKeys("123@34");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.linkText("Success")).isDisplayed());
		
		String actualProperDetails0= "Your Account Has Been Created!";
		String actualProperDetails1= "Congratulations! Your new account has been successfully created!";
		String actualProperDetails2="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetails3 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDetails4 = "contact us";
		
		String expectedProperDetails = driver.findElement(By.xpath("//div[@id= 'content']")).getText();
		
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails0));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails1));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails2));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails3));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails4));
		
		driver.findElement(By.linkText("Continue")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		
		
		driver.quit();
		

	}
	

		

	

}
