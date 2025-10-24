package tutorialninja.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtils;

public class baseClass {

	protected WebDriver driver;

	public WebDriver openBrowserAndApplication() {
		Properties prop = CommonUtils.loadProperties();
		String browserName = prop.getProperty("browserName");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\geckodriver-v0.36.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(prop.getProperty("URL"));

		return driver;

	}

	public WebDriver nevigateToRegisterAccountPage(WebDriver driver, String url) {
		driver.navigate().to(url);
		return driver;
	}

	public WebDriver pressTabButtonMultipleTime(WebDriver driver, Keys keyName, int count) {
		Actions actions = new Actions(driver);
		for (int i = 0; i < count; i++) {
			actions.sendKeys(keyName).build().perform();
		}

		return driver;
	}

	public WebDriver nevigateBack(WebDriver driver) {
		driver.navigate().back();
		return driver;
	}

}
