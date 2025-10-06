package tutorialninja.register;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.baseClass;
import utils.CommonUtils;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_023 extends baseClass {
	Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = CommonUtils.loadProperties();
		openBrowserAndApplication();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifyLinksAreClickableOnRegisterPage() throws InterruptedException {

		driver.findElement(By.linkText("login page")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.linkText("Privacy Policy")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='modal-body']/p")).isDisplayed());
		driver.findElement(By.xpath("//div[@class='modal-header']/button")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='123456789']")).isDisplayed());

		driver.findElement(By.linkText("My Account")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.findElement(By.id("wishlist-total")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.linkText("Shopping Cart")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Shopping Cart")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.linkText("Checkout")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Shopping Cart")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//div[@id='logo']/h1/a")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=common/home");

		driver.navigate().back();

//		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("Search")).isDisplayed());
//		Thread.sleep(3000);
//		driver.navigate().back();
//		
//		driver.findElement(By.linkText("Desktops")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("PC (0)")).isDisplayed());
//		Assert.assertTrue(driver.findElement(By.linkText("Mac (1)")).isDisplayed());
//		
//		driver.findElement(By.linkText("Laptops & Notebooks")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("Macs (0)")).isDisplayed());
//		Assert.assertTrue(driver.findElement(By.linkText("Windows (0)")).isDisplayed());
//		
//		driver.findElement(By.linkText("Components")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("Mice and Trackballs (0)")).isDisplayed());
//		Assert.assertTrue(driver.findElement(By.linkText("Monitors (2)")).isDisplayed());
//		Assert.assertTrue(driver.findElement(By.linkText("Printers (0)")).isDisplayed());
//		Assert.assertTrue(driver.findElement(By.linkText("Scanners (0)")).isDisplayed());
//		Assert.assertTrue(driver.findElement(By.linkText("Web Cameras (0)")).isDisplayed());
//		
//		driver.findElement(By.linkText("Tablets")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("Tablets")).isDisplayed());
//		
//		driver.navigate().back();
//		
//		driver.findElement(By.linkText("Software")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("Software")).isDisplayed());
//		
//		driver.navigate().back();
//		
//		driver.findElement(By.linkText("Phones & PDAs")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("Phones & PDAs")).isDisplayed());
//		
//		driver.navigate().back();
//		Thread.sleep(3000);
//		driver.findElement(By.linkText("Cameras")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("Cameras")).isDisplayed());
//		Thread.sleep(3000);
//		driver.navigate().back();
//		
//		driver.findElement(By.linkText("MP3 Players")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("test 11 (0)")).isDisplayed());

		Thread.sleep(3000);
		driver.findElement(By.linkText("Login")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.linkText("Register")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());

		driver.findElement(By.linkText("Forgotten Password")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Forgotten Password")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[@class='list-group-item'][text()='My Account']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Address Book']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.linkText("Wish List")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.linkText("Order History")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.linkText("Downloads")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.linkText("Recurring payments")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.linkText("Reward Points")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.linkText("Returns")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.linkText("Transactions")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.linkText("Newsletter")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[text()='About Us']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(),'About Us')]"))
				.isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[text()='Delivery Information']")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(), 'Delivery Information')]"))
						.isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[text()='Privacy Policy']")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(), 'Privacy Policy')]"))
						.isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[text()='Terms & Conditions']")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(), 'Terms & Conditions')]"))
						.isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(), 'Contact Us')]"))
				.isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[contains(text(), 'Returns')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Product Returns']")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[text()='Site Map']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(), 'Site Map')]"))
				.isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[text()='Brands']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Brand']")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[text()='Gift Certificates']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Gift Certificate']")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[text()='Affiliate']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Affiliate Program']")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[text()='Specials']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Special Offers']")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[contains(text(), 'My Account')]")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(), 'Login')]")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[contains(text(), 'Order History')]")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(), 'Login')]")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[contains(text(), 'Wish List')]")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(), 'Login')]")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[contains(text(), 'Newsletter')]")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(), 'Login')]")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[text()='OpenCart']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.opencart.com/");

		driver.navigate().back();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
