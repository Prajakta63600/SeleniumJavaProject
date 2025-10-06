package Base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.CommonUtils;

public class baseClass {
	
	protected WebDriver driver;
	
	public WebDriver openBrowserAndApplication()
	{
		Properties prop = CommonUtils.loadProperties();
		String browserName = prop.getProperty("browserName");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\geckodriver-v0.36.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(prop.getProperty("URL"));
		
		return driver;

	}

}
