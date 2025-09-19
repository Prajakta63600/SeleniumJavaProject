package tutorialninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class TC_012 {
	
	@Test
	public void verifyRegisterAccountPageUsingKeyboardKeys()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		 driver.findElement(By.linkText("My Account")).click();
	     driver.findElement(By.linkText("Register")).click();
	     
	     Actions actions = new Actions(driver);
	     for(int i=0; i<23; i++) 
	     {
	     actions.sendKeys(Keys.TAB).perform();
	     }
	     
	     actions.sendKeys("Tony").sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
	     .sendKeys("Stark").sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
	     .sendKeys(CommonUtils.generateEmail()).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
	     .sendKeys("1234567894").sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
	     .sendKeys("1234").sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
	     .sendKeys("1234").sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
	     .sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
	     
	     Assert.assertEquals(driver.findElement(By.linkText("Logout")).getText(), "Logout");
	     Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h1")).isDisplayed());
	     
	     driver.quit();
	}
	
	

}
