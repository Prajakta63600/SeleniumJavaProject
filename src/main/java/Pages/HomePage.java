package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountdropdwonMenu;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	private WebElement registerOption;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;

	public void clickOnMyAccount() {
		myAccountdropdwonMenu.click();
	}

	public RegisterAccountPage selectRegisterOption() {
		registerOption.click();
		return new RegisterAccountPage(driver);
	}
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}

}
