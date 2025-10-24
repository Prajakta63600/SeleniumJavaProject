package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditInformationPage {
	
	WebDriver driver;
	
	public EditInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-firstname")
	private WebElement firstName;
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	public String getFirstNameAttribute() {
		return firstName.getDomAttribute("value");
	}
	
	public String getLastNameAttribute() {
		return lastName.getDomAttribute("value");
	}
	
	public String getEmailAttribute() {
		return email.getDomAttribute("value");
	}
	
	public String getTelephoneAttribute() {
		return telephone.getDomAttribute("value");
	}
	

}
