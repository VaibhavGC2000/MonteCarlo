package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(css = "input[id='customer[email]']")
	private WebElement email;

	@FindBy(css = "input[id='customer[password]']")
	private WebElement password;

	@FindBy(xpath = "//div[@class='login_form_no']//button[@type='submit']")
	private WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}

	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}
}
