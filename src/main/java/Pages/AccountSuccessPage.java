package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
	WebDriver driver;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//aside[@id='column-right']//a[normalize-space()='Logout']")
	private WebElement logoutOption;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement accountCreatedHeaderMsg;
	
	@FindBy(xpath="//div[@id='content']")
	private WebElement registeredSuccessMessage;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	private WebElement continueButton;
	
	@FindBy(linkText="Success")
	private WebElement success;
	
	@FindBy(xpath="//div[@id='content']//h1")
	private WebElement accountCreatedTitle;
	
	public boolean logout() {
		return logoutOption.isDisplayed();
	}
	
	public String logoutGetText() {
		return logoutOption.getText();
	}
	
	public String HeaderMessage(){
		return accountCreatedHeaderMsg.getText();
	}
	
	public String RegisteredSuccessfulyMsg() {
		return registeredSuccessMessage.getText();
	}
	
	public AccountPage clickContinueButton() {
		continueButton.click();
		return new AccountPage(driver);
	}
	
	public boolean successBreadCrumb() {
		return success.isDisplayed();
	}
	
	public boolean accountCreatedTitleMsg() {
		return accountCreatedTitle.isDisplayed();
	}

}
