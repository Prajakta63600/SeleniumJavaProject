package tutorialninja.register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;



import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_010_02 {

    @Test
    public void verifyEmailFieldWithDifferentData() throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Tony");
        driver.findElement(By.id("input-lastname")).sendKeys("Stark");
        driver.findElement(By.id("input-email")).sendKeys("tony@");
        driver.findElement(By.id("input-telephone")).sendKeys("2345555555");
        driver.findElement(By.id("input-password")).sendKeys("tony123");
        driver.findElement(By.id("input-confirm")).sendKeys("tony123");
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
       //Thread.sleep(2000); // Wait for 3 seconds to ensure the page is fully loaded

		
		File srcScreenshot2 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot2,new File(System.getProperty("user.dir")+"\\Screenshots\\sc2Actual.png"));
		
		Assert.assertFalse(compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\sc2Actual.png", System.getProperty("user.dir")+"\\Screenshots\\expectedemailfield2.png", System.getProperty("user.dir")+"\\Screenshots\\expectedemailfield201.png"));
       
       
        driver.quit();
    }
    
    public boolean compareTwoScreenshots(String actualImagePath, String expectedImagePath1, String expectedImagePath2) throws IOException
    {
		
		BufferedImage actualImage1 = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc2Actual.png"));
		BufferedImage expectedImage1 = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\expectedemailfield2.png"));
		BufferedImage expectedImage2 = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\expectedemailfield201.png"));
        
       ImageDiffer imgDiffer = new ImageDiffer();
       ImageDiff imgDifference1 = imgDiffer.makeDiff(actualImage1, expectedImage1);
       
       ImageDiff imgDifference2 = imgDiffer.makeDiff(actualImage1, expectedImage2);

       // Return true if either comparison has NO difference
       return !imgDifference1.hasDiff() || !imgDifference2.hasDiff();
       
       
     
    }
}
