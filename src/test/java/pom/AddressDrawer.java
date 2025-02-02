package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressDrawer {

	@FindBy(id = "address-new[first_name]")
	private WebElement firstNameBox;

	@FindBy(id = "address-new[last_name]")
	private WebElement lastNameBox;

	@FindBy(id = "address-new[phone]")
	private WebElement phoneBox;

	@FindBy(id = "address-new[company]")
	private WebElement companyBox;

	@FindBy(id = "address-new[address1]")
	private WebElement add1Box;

	@FindBy(id = "address-new[address2]")
	private WebElement add2Box;

	@FindBy(id = "address-new[city]")
	private WebElement cityBox;

	@FindBy(id = "address-new[zip]")
	private WebElement zipBox;

	@FindBy(id = "address-new[default]")
	private WebElement defaultCheckBox;
	
	@FindBy(xpath = "//form[@id='address_form_new']//button[@type='submit']")
	private WebElement addNewAddressBtn;

	public void enterFirstName(String name) {
		firstNameBox.sendKeys(name);
	}

	public void enterLastName(String name) {
		lastNameBox.sendKeys(name);
	}

	public void enterCompany(String text) {
		companyBox.sendKeys(text);
	}

	public void enterPhone(String text) {
		phoneBox.sendKeys(text);
	}

	public void enterAddressOne(String text) {
		add1Box.sendKeys(text);
	}

	public void enterAddressTwo(String text) {
		add2Box.sendKeys(text);
	}

	public void enterCity(String text) {
		cityBox.sendKeys(text);
	}

	public void enterZip(String text) {
		zipBox.sendKeys(text);
	}

	public AddressDrawer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickDefaultCheckBox(String text) {
		defaultCheckBox.click();
	}

	public void clickAddAddressBtn() {
		addNewAddressBtn.click();
	}

}
