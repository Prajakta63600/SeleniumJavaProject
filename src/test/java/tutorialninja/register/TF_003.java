package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TF_003 {

	@Test
	public void verifyValidationMessageOnRegisterPage() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(5000);
		
		String FirstNameError=driver.findElement(By.xpath("//input[@id ='input-firstname']/following-sibling::div")).getText();
		
		
		Assert.assertTrue(FirstNameError.contains("First Name must be between 1 and 32 characters!"));
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id ='input-lastname']/following-sibling::div")).getText(), "Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id ='input-email']/following-sibling::div")).getText(), "E-Mail Address does not appear to be valid!");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id ='input-telephone']/following-sibling::div")).getText(), "Telephone must be between 3 and 32 characters!");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id ='input-password']/following-sibling::div")).getText(), "Password must be between 4 and 20 characters!");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), "Warning: You must agree to the Privacy Policy!");
		driver.quit();
		

	}

}
