package tutorialninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class TC_001 {
	
    @Test
	public  void registerWithEmail() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Prajakta");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Naik");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(CommonUtils.generateEmail());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
		
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//aside[@id='column-right']//a[normalize-space()='Logout']")).isDisplayed());
		
		String actualRegisterSuccessDetails= driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(actualRegisterSuccessDetails, "Your Account Has Been Created!");
		
		String actualProperDetailsOne= "Congratulations! Your new account has been successfully created!";
		String actualProperDetailsTwo="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDetailsFour = "contact us";
		
		String expectedProperDetails = driver.findElement(By.xpath("//div[@id='content']")).getText();
		
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsOne));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsTwo));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsThree));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsFour));
		
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Edit your account information']")).isDisplayed());
		
		driver.quit();

	}
	
	

}
