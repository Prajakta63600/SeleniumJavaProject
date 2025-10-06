package tutorialninja.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.baseClass;
import utils.CommonUtils;

public class TC_015 {

	WebDriver driver;
	String url = "jdbc:mysql://localhost:3306/opencart_db";
	String username = "root"; // your MySQL username
	String password = null; // your MySQL password

	@BeforeMethod
	public void setUp() {

		String browserName = "firefox";
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
		driver.get("http://localhost/opencart/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifyDatabaseTestingOfRegisteringAccount() throws InterruptedException {

		driver.findElement(By.id("input-firstname")).sendKeys("Tony");
		driver.findElement(By.id("input-lastname")).sendKeys("Stark");

		String emailInput = CommonUtils.generateEmail();
		emailInput = emailInput.toLowerCase();
		driver.findElement(By.id("input-email")).sendKeys(emailInput);
		driver.findElement(By.id("input-password")).sendKeys("1234556");
		WebElement newsletter = driver.findElement(By.id("input-newsletter"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", newsletter);

		WebElement agree = driver.findElement(By.name("agree"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", agree);

		WebElement continueButton = driver.findElement(By.xpath("//button[text()='Continue']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);

		Thread.sleep(5000);

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String firstName = null;
		String lastName = null;
		String email = null;

		try {
			// 1. Load the MySQL JDBC driver (optional for newer versions)
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Establish connection
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to MySQL database!");

			// 3. Create a statement
			stmt = conn.createStatement();

			// 4. Execute a query
			rs = stmt.executeQuery("SELECT * FROM oc_customer");

			// 5. Process the result set
			while (rs.next()) {
				firstName = rs.getString("firstname");
				lastName = rs.getString("lastname");
				email = rs.getString("email");

				System.out.println("firstName: " + firstName + ", lastName: " + lastName + ", Email: " + email);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Database connection error.");
			e.printStackTrace();
		} finally {
			// 6. Close resources
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		Assert.assertEquals(firstName, "Tony");
		Assert.assertEquals(lastName, "Stark");
		Assert.assertEquals(email, emailInput);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
